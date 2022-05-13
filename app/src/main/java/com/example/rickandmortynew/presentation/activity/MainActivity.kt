package com.example.rickandmortynew.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationItemReselectedListener: OnBottomNavigationItemReselect

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_characters,
                R.id.navigation_episodes,
                R.id.navigation_locations,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    private fun setupNavigation() {
        binding.bottomNavigation.apply {
            itemIconTintList = null
            setupWithNavController(navController)

            setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.navigation_characters,
                    R.id.navigation_episodes,
                    R.id.navigation_locations -> {
                        bottomNavigationItemReselectedListener.onItemReselect()
                    }
                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun interface OnBottomNavigationItemReselect {
        fun onItemReselect()
    }

    fun setOnBottomNavigationItemReselectListener(bottomNavigationItemReselectListener: OnBottomNavigationItemReselect) {
        this.bottomNavigationItemReselectedListener = bottomNavigationItemReselectListener
    }
}
