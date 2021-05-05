package com.shareefoo.viledtask.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.shareefoo.viledtask.adapters.CategoryItemAdapter
import com.shareefoo.viledtask.adapters.ServiceItemAdapter
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.databinding.DetailsFragmentBinding
import com.shareefoo.viledtask.repositories.GeneralRepository
import com.shareefoo.viledtask.ui.main.MainFragment
import com.shareefoo.viledtask.ui.main.MainViewModel
import com.shareefoo.viledtask.ui.main.MainViewModelFactory

class DetailsFragment : Fragment() {

    private var _binding: DetailsFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var mCategoryAdapter: CategoryItemAdapter
    private lateinit var mServicesList: List<Service>
    private lateinit var mCategoriesList: List<Category>

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val repository = GeneralRepository()

        viewModel = ViewModelProvider(
            requireActivity(), MainViewModelFactory(repository)
        ).get(MainViewModel::class.java)

        viewModel.servicesList.observe(viewLifecycleOwner, Observer { servicesList ->
            mServicesList = servicesList

            viewModel.categoriesList.observe(viewLifecycleOwner, Observer { categoriesList ->
                mCategoriesList = categoriesList

                val args: DetailsFragmentArgs by navArgs()
                val serviceId = args.humanizedId

                // TODO: delegate to ViewModel (Business Logic)
                // get current service from passed id
                for (service in mServicesList) {
                    if (service.humanizedId == serviceId) {
                        // extract current service categories
                        val newList = ArrayList<Category>()
                        val categoriesIdList: List<String> = service.categoryIds
                        for (categoryId in categoriesIdList) {
                            for (category in mCategoriesList) {
                                if (categoryId == category.id) {
                                    newList.add(category)
                                }
                            }
                        }
                        mCategoryAdapter = CategoryItemAdapter(newList.toList())
                        binding.rvCategories.adapter = mCategoryAdapter
                    }
                }
            })
        })
    }

    // Clean up any references to the binding class instance
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}