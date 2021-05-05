package com.shareefoo.viledtask.ui.master

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shareefoo.viledtask.adapter.ServiceItemAdapter
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.databinding.MasterFragmentBinding
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MasterFragment : Fragment() {

    private var _binding: MasterFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mServiceAdapter: ServiceItemAdapter
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
        _binding = MasterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val repository = GeneralRepository()

//        viewModel = ViewModelProvider(
//            requireActivity(), MainViewModelFactory(repository)
//        ).get(MainViewModel::class.java)

        viewModel.getGeneralResponse().observe(viewLifecycleOwner, {
            viewModel.spinner.postValue(false)

            viewModel.setServices(it.services)
            viewModel.setCategories(it.categories)

            mServicesList = it.services
            mCategoriesList = it.categories

            mServiceAdapter = ServiceItemAdapter(mServicesList, mCategoriesList)
            binding.rvServices.adapter = mServiceAdapter
        })

        // show the spinner when [MainViewModel.spinner] is true
        viewModel.spinner.observe(viewLifecycleOwner) { value ->
            value.let { show ->
                binding.spinner.visibility = if (show) View.VISIBLE else View.GONE
            }
        }

    }

    // Clean up any references to the binding class instance
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}