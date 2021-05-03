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
import com.shareefoo.viledtask.adapters.CategoryItemAdapter
import com.shareefoo.viledtask.databinding.MainFragmentBinding
import com.shareefoo.viledtask.models.Category
import com.shareefoo.viledtask.repositories.GeneralRepository


class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null

//    private val mFactory: MainViewModelFactory

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private var mCategoryAdapter: CategoryItemAdapter? = null
    private var mCategories: List<Category>? = null
    private var mCategoriesRecyclerView: RecyclerView? = null

    private var layoutManager: RecyclerView.LayoutManager? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvCategories.layoutManager = LinearLayoutManager(context)

        return view
//        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val repository = GeneralRepository()

        viewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.getGeneralResponse().observe(this, {
            mCategories = it.categories
            mCategoryAdapter = CategoryItemAdapter(mCategories!!)

            binding.rvCategories.adapter = mCategoryAdapter
        })
    }

    // Clean up any references to the binding class instance
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}