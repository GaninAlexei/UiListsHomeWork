package com.homework.uilistshomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MoviesAdapter.IMovieClick {

    private lateinit var adapter: MoviesAdapter

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MoviesAdapter(this)
        binding.recyclerView1.adapter = adapter
        adapter.submitList(MockUtil.getHeaderMoviesList(this))

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 0) {
                    adapter.submitList(MockUtil.getHeaderMoviesList(this@MainActivity))
                } else {
                    adapter.submitList(MockUtil.getHeaderWatchedMoviesList(this@MainActivity))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}

        })

    }

    override fun onDelete(item: Item) {
        val list = adapter.currentList.toMutableList().also { it.remove(item) }
        adapter.submitList(list)
    }

}
