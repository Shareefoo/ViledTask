package com.shareefoo.viledtask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.shareefoo.viledtask.adapters.ServiceItemAdapter
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.databinding.MainFragmentBinding
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.repositories.GeneralRepository
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mServiceAdapter: ServiceItemAdapter
    private lateinit var mServicesList: List<Service>
    private lateinit var mCategoriesList: List<Category>

    companion object {
        fun newInstance() = MainFragment()
    }

    // lazy inject MainViewModel
    val viewModel: MainViewModel by viewModel()

//    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        val repository = GeneralRepository()

//        viewModel = ViewModelProvider(
//            requireActivity(), MainViewModelFactory(repository)
//        ).get(MainViewModel::class.java)

        viewModel.getGeneralResponse().observe(viewLifecycleOwner, {

            viewModel.setServices(it.services)
            viewModel.setCategories(it.categories)

            mServicesList = it.services
            mCategoriesList = it.categories

            mServiceAdapter = ServiceItemAdapter(mServicesList, mCategoriesList)
            binding.rvServices.adapter = mServiceAdapter
        })
    }

    // Clean up any references to the binding class instance
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}