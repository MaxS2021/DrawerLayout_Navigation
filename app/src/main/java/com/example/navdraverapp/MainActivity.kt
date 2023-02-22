package com.example.navdraverapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navdraverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var conf: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        setSupportActionBar(bind.aBar.toolbar)
        //setupActionBarWithNavController(navController)
        conf = AppBarConfiguration(
            setOf(
                R.id.item1,
                R.id.item2
            ), bind.drawer
        )
        setupActionBarWithNavController(navController, conf)
        bind.navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(conf) || super.onSupportNavigateUp()
    }
}