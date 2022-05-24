package com.example.amazonkotlin

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var rv_essential: RecyclerView? = null
    lateinit var ll_fashion: ConstraintLayout
    lateinit var ll_popular: ConstraintLayout
    var list = ArrayList<Essential>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_popular)
        rv_essential = findViewById(R.id.rv_essential)
        rv_essential?.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        val adapter = EssentialAdapter(this, list)
        rv_essential?.setAdapter(adapter)
        data()
        //        refreshAdapter();
        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
    }

    private fun data() {
        list.add(Essential(R.drawable.im_product_3, "Ocolus"))
        list.add(Essential(R.drawable.im_product_2, "Gamer"))
        list.add(Essential(R.drawable.im_product_1, "Mobile"))
    }

    private fun setLinearHeight(layout: ConstraintLayout) {
        val windowManager = applicationContext.getSystemService(WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val displayMetrics = DisplayMetrics()
        display.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val params = layout.layoutParams
        params.height = width
    }
}