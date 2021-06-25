package com.faridrama123.transgeo.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.faridrama123.transgeo.R
import com.faridrama123.transgeo.databinding.ActivityHomeBinding
import com.faridrama123.transgeo.ui.menu.FragmentMenu2
import com.faridrama123.transgeo.ui.menu.TentangFragment




class HomeActivity : AppCompatActivity() {

    private var homeActivity : ActivityHomeBinding? = null
    private val binding get() = homeActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivity = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)


    }


    fun kikd(view: View) {
        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TentangFragment.newInstance("KIKD"))
            .commitNow()

    }

    fun tentang(view: View) {
        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TentangFragment.newInstance("TENTANG"))
            .commitNow()

    }
    fun bantuan(view: View) {
        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TentangFragment.newInstance("BANTUAN"))
            .commitNow()
    }

    fun translasi(view: View) {

        binding?.btnTittle?.setText("TRANSLASI")


        binding?.title?.setVisibility(View.VISIBLE)
        binding?.menu1?.setVisibility(View.GONE)


        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMenu2.newInstance("TRANSLASI"))
            .commitNow()
    }
    fun dilatasi(view: View) {
        binding?.btnTittle?.setText("DILATASI")

        binding?.title?.setVisibility(View.VISIBLE)
        binding?.menu1?.setVisibility(View.GONE)


        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMenu2.newInstance("DILATASI"))
            .commitNow()
    }
    fun rotasi(view: View) {
        binding?.btnTittle?.setText("ROTASI")

        binding?.title?.setVisibility(View.VISIBLE)
        binding?.menu1?.setVisibility(View.GONE)


        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMenu2.newInstance("ROTASI"))
            .commitNow()
    }
    fun refleksi(view: View) {
        binding?.btnTittle?.setText("REFLEKSI")

        binding?.title?.setVisibility(View.VISIBLE)
        binding?.menu1?.setVisibility(View.GONE)
        binding?.container?.setVisibility(View.VISIBLE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMenu2.newInstance("REFLEKSI"))
            .commitNow()
    }

    fun back(view: View) {

        binding?.menu1?.setVisibility(View.VISIBLE)
        binding?.title?.setVisibility(View.GONE)
        binding?.container?.setVisibility(View.GONE)



    }


}