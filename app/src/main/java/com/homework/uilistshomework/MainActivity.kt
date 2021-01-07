package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MoviesAdapter.IMovieClick {

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MoviesAdapter()
        binding.recyclerView1.adapter = adapter
        adapter.list = MockUtil.getHeaderMoviesList(this)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab == null) return

                if (tab.position == 0) {

                    binding.recyclerView1.adapter = adapter
                    adapter.list = MockUtil.getHeaderMoviesList(this@MainActivity)

                } else {

                    binding.recyclerView1.adapter = adapter
                    adapter.list = MockUtil.getHeaderWatchedMoviesList(this@MainActivity)

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

    }

    override fun onDelete(position: Int) {
        TODO("Not yet implemented")
    }

}
