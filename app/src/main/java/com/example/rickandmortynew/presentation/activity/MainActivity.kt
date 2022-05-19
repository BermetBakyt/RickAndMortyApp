package com.example.rickandmortynew.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationItemReselectListener: OnBottomNavigationItemReselect

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupBottomNavigation()
        setupToolbar()
        updateUIComponents()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_locations,
                R.id.navigation_episodes,
                R.id.navigation_characters,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.apply {
            //May be deleted?
            itemIconTintList = null
            setupWithNavController(navController)

            //sets Listener to Item reselected. Its deprecated, instead use setOnItemReselected
            setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.navigation_locations,
                    R.id.navigation_episodes,
                    R.id.navigation_characters -> {
                        bottomNavigationItemReselectListener.onItemReselect()
                    }
                }
            }
        }
    }

    // dont understand deepply. Ask to explain
    private fun updateUIComponents() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.characterDetailFragment,
                R.id.locationDetailFragment,
                R.id.episodeDetailFragment
                -> {
                    //TODO: scroll up bottom navigation and toolbar, because their hided when scroll and open detail not showing
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun interface OnBottomNavigationItemReselect {
        fun onItemReselect()
    }

    fun setOnBottomNavigationItemReselectListener(bottomNavigationItemReselectListener: OnBottomNavigationItemReselect) {
        this.bottomNavigationItemReselectListener = bottomNavigationItemReselectListener
    }
}
