package com.androiddev.mytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_display)

        val product_image: ImageView = findViewById(R.id.pdt_image)
        val product_title: TextView = findViewById(R.id.pdt_title)
        val product_description: TextView = findViewById(R.id.pdt_description)

        val bundle :Bundle? = intent.extras
        val productImage = bundle!!.getInt("productImage")
        val productTitle = bundle.getString("productTitle")
        val productDescription = bundle.getString("productDescription")

        product_image.setImageResource(productImage)
        product_title.text = productTitle
        product_description.text = productDescription

    }
}