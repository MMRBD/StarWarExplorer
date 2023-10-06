package com.mmrbd.starwarsexplorer

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.doOnNextLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mmrbd.starwarsexplorer.base.activity.BaseActivity
import com.mmrbd.starwarsexplorer.base.contract.BaseContract
import com.mmrbd.starwarsexplorer.databinding.ActivityMainBinding
import com.mmrbd.starwarsexplorer.utils.AppLogger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<BaseContract.State, ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val visibleBottomNavigationIds = listOf(
        R.id.navHome,
        R.id.navPlanets,
        R.id.navStarships,
    )

    private lateinit var navController: NavController


    override val model: ManinViewModel by viewModels()

    override fun ActivityMainBinding.initialiseView(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(
            navController, AppBarConfiguration(
                visibleBottomNavigationIds.toSet()
            )
        )

        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val visibility =
                if (visibleBottomNavigationIds.any { inside -> inside == destination.id }) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

            root.doOnNextLayout {
                navView.visibility = visibility
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.popBackStack() || super.onSupportNavigateUp()
    }
}