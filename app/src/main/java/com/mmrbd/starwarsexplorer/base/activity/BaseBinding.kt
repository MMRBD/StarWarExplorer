package com.mmrbd.starwarsexplorer.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import com.mmrbd.starwarsexplorer.utils.AppLogger

abstract class BaseBinding<Binding : ViewBinding>(
    private val bindingInflater: (LayoutInflater) -> Binding
) : AppCompatActivity() {

    var binding: Binding? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        initialiseActivity()
        binding = bindingInflater(layoutInflater)
        setContentView(binding!!.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding!!.initialiseView(savedInstanceState)
    }

    // Template
    private fun initialiseActivity() {

        AppLogger.log("initialiseActivity")

    }

    open fun Binding.initialiseView(savedInstanceState: Bundle?) {

        AppLogger.log("initialiseView")
        // Template
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}