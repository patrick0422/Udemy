package com.example.foodyclone.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodyclone.MainViewModel
import com.example.foodyclone.R
import com.example.foodyclone.adapters.RecipesAdapter
import com.example.foodyclone.databinding.FragmentRecipesBinding
import com.example.foodyclone.util.Constants.Companion.API_KEY
import com.example.foodyclone.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesFragment : Fragment() {
    private lateinit var binding: FragmentRecipesBinding
    private lateinit var mViewModel: MainViewModel
    private val mAdapter by lazy { RecipesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes, container, false)

        mViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        setUpRecyclerView()
        requestApiData()

        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        showShimmer()
    }

    private fun requestApiData() {
        mViewModel.getRecipes(applyQueries())
        mViewModel.recipeResponse.observe(viewLifecycleOwner, { response ->
            when(response) {
                is NetworkResult.Success -> {
                    hideShimmer()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmer()
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    showShimmer()
                }
            }
        })
    }

    private fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        queries["number"] = "50"
        queries["apiKey"] = API_KEY
        queries["type"] = "snack"
        queries["diet"] = "vegan"
        queries["addRecipeInformation"] = "true"
        queries["fillIngredients"] = "true"

        return queries
    }


    private fun showShimmer() {
        binding.recyclerview.showShimmer()
    }

    private fun hideShimmer() {
        binding.recyclerview.hideShimmer()
    }
}