package com.example.ispitmodul3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ispitmodul3.databinding.ActivityMainBinding
import com.example.ispitmodul3.model.Grocery
import com.example.ispitmodul3.other.GroceryAdapter
import com.example.ispitmodul3.other.OnItemClickListener
import com.example.ispitmodul3.viewmodel.GroceryViewModel

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var allGroceries: LiveData<List<Grocery>>

    private lateinit var groceryViewModel: GroceryViewModel
    private lateinit var adapter: GroceryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        saveData()

        groceryViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[GroceryViewModel::class.java]

        allGroceries = groceryViewModel.allGroceries
        allGroceries.observe(this, object : Observer<List<Grocery>> {
            override fun onChanged(list: List<Grocery>?) {
                list?.let {
                    adapter.groceries = it
                }
            }

        })
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = GroceryAdapter()
        binding.recyclerView.adapter = adapter
        adapter.onItemClickListener = this
    }

    override fun onItemClicked(grocery: Grocery) {
        TODO("Not yet implemented")
    }

    private fun saveData() {
        binding.btnSave.setOnClickListener {
            if (binding.etGroceryName.text.toString().isEmpty()) {
                binding.etNumberOfCalories.error = "Grocery name is missing, cant save to list"
            } else if (binding.etNumberOfCalories.text.toString().isEmpty()) {
                binding.etNumberOfCalories.error = "Grocery calories are missing, cant save to list"
            } else {
                val grocery = Grocery(
                    binding.etGroceryName.text.toString(),
                    binding.etNumberOfCalories.text.toString().toInt()
                )
                groceryViewModel.insert(grocery)
            }
        }
    }
}