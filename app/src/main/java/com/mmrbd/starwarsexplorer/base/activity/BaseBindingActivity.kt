package com.mmrbd.starwarsexplorer.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import com.mmrbd.starwarsexplorer.utils.AppLogger

abstract class BaseBindingActivity<Binding : ViewBinding>(
    private val bindingInflater: (LayoutInflater) -> Binding
) : AppCompatActivity() {

    var binding: Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseActivity()
        binding = bindingInflater(layoutInflater)
        setContentView(binding!!.root)

        binding?.initialiseView(savedInstanceState)
    }

    /** Override to do further initialisation of the Activity.
     *  This is called immediately after [super.onCreate(savedInstanceState)] */
    protected open fun initialiseActivity() {
        // Template
    }

    /** Override to initialise view */
    open fun Binding.initialiseView(savedInstanceState: Bundle?) {
        // Template
    }

    /**
     * Destroy binding
     */
    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}