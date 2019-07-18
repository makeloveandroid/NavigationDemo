package com.qihoo.jectpackdemo.ui.actvity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.qihoo.jectpackdemo.R

class LoginActivity : AppCompatActivity() {
    val bottomNavigationView: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_nav_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navHostFragment.navController.apply {
            bottomNavigationView.setupWithNavController(this)
        }
    }
}
