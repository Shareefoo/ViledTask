package com.shareefoo.viledtask.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.shareefoo.viledtask.R
import com.shareefoo.viledtask.adapter.CategoryItemAdapter
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.databinding.DetailsFragmentBinding
import com.shareefoo.viledtask.ui.master.MasterFragment
import com.shareefoo.viledtask.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private var _binding: DetailsFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mCategoryAdapter: CategoryItemAdapter
    private lateinit var mServicesList: List<Service>
    private lateinit var mCategoriesList: List<Category>

    companion object {
        fun newInstance() = MasterFragment()
    }

    // Lazy inject MainViewModel
    val viewModel: MainViewModel by viewModel()
//    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val repository = GeneralRepository()
//
//        viewModel = ViewModelProvider(
//            requireActivity(), MainViewModelFactory(repository)
//        ).get(MainViewModel::class.java)

        mServicesList = viewModel.servicesList.value!!

        mCategoriesList = viewModel.categoriesList.value!!

//        viewModel.servicesList.observe(viewLifecycleOwner, Observer { servicesList ->
//            mServicesList = servicesList
//
//            viewModel.categoriesList.observe(viewLifecycleOwner, Observer { categoriesList ->
//                mCategoriesList = categoriesList

        val args: DetailsFragmentArgs by navArgs()
        val serviceId = args.humanizedId

        // TODO: delegate to ViewModel (Business Logic)
        // get current service from passed id
        for (service in mServicesList) {
            if (service.humanizedId == serviceId) {
                // extract current service categories
                binding.tvCategories.text =
                    service.title + " " + resources.getString(R.string.categories)
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
//            })
//        })
    }

    // Clean up any references to the binding class instance
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}