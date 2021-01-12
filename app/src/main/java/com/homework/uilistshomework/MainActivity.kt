package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        adapter.submitList(MockUtil.getHeaderMoviesList())

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {

                if (tab.position == 0) {
                    adapter.submitList(MockUtil.getHeaderMoviesList())
                } else {
                    adapter.submitList(MockUtil.getHeaderWatchedMoviesList())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                //do nothing here
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                //do nothing here
            }

        })

    }

    override fun onDelete(position: Item) {
        val list = adapter.currentList.toMutableList().also { it.remove(position) }
        adapter.submitList(list)
    }

}
