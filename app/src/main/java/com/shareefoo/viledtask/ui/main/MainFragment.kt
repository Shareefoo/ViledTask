package com.shareefoo.viledtask.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shareefoo.viledtask.adapters.ServiceItemAdapter
import com.shareefoo.viledtask.databinding.MainFragmentBinding
import com.shareefoo.viledtask.models.Service
import com.shareefoo.viledtask.repositories.GeneralRepository


class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mServiceAdapter: ServiceItemAdapter
    private lateinit var mServicesList: List<Service>

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvServices.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val repository = GeneralRepository()

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.getGeneralResponse().observe(this, {
            mServicesList = it.services
            mServiceAdapter = ServiceItemAdapter(mServicesList)
            binding.rvServices.adapter = mServiceAdapter
        })
    }

    // Clean up any references to the binding class instance
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}