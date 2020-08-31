package com.shivam.newsy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shivam.newsy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val categoriesFragment = CategoriesFragment()
    private val bookmarkFragment = BookmarkFragment()
    private val settingsFragment = SettingsFragment()
    private var activeFragment: Fragment = HomeFragment()
    private val fragmentManager = supportFragmentManager

    private lateinit var binding: ActivityMainBinding


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragmentManager.beginTransaction().apply {
            add(R.id.nav_host_fragment, homeFragment, getString(R.string.home)).hide(homeFragment)
            add(R.id.nav_host_fragment, categoriesFragment, getString(R.string.categories)).hide(
                categoriesFragment
            )
            add(R.id.nav_host_fragment, bookmarkFragment, getString(R.string.bookmark)).hide(
                bookmarkFragment
            )
            add(R.id.nav_host_fragment, settingsFragment, getString(R.string.settings)).hide(
                settingsFragment
            ).commit()
        }

        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
        activeFragment = homeFragment

        initListeners()

    }

    private fun initListeners() {
        binding.bottomNavView.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ menuItem ->
            when (menuItem.itemId) {
                R.id.item_home -> {
                    fragmentTransaction(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_categories -> {
                    fragmentTransaction(categoriesFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_bookmark -> {
                    fragmentTransaction(bookmarkFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_settings -> {
                    fragmentTransaction(settingsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                else -> return@OnNavigationItemSelectedListener false
            }
        }
    }

    private fun fragmentTransaction(currentFragment : Fragment){
        supportFragmentManager.beginTransaction().hide(activeFragment).show(currentFragment).commit()
        activeFragment = currentFragment
    }

// BottomNavigation View with Navigation Components
//    private fun setupViews() {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        binding.bottomNavView.setupWithNavController(navController)
//    }
}