package com.androiddev.mytask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.adapter.ProductAdapter
import com.androiddev.data.Product
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter:ProductAdapter
    private lateinit var productList:ArrayList<Product>
    private lateinit var productImage:Array<Int>
    private lateinit var productTitle:Array<String>
    private lateinit var productDescription: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //array of image
        productImage = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k
        )
        //array of title
        productTitle = arrayOf(
            "anime1",
            "anime2",
            "anime3",
            "anime4",
            "anime5",
            "anime6",
            "anime7",
            "anime8",
            "anime9",
        )
        //array of Product productDescription
        productDescription = arrayOf(
            getString(R.string.descOne),
            getString(R.string.descTwo),
            getString(R.string.descThree),
            getString(R.string.descFour),
            getString(R.string.descFive),
            getString(R.string.descSix),
            getString(R.string.descSeven),
            getString(R.string.descEight),
            getString(R.string.descNine)
        )
        recyclerView = findViewById(R.id.rv_productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        productList = arrayListOf<Product>()
        getProductList()
        productAdapter = ProductAdapter(productList)

    }

    private fun getProductList() {
        for(i in productImage.indices){
            val product = Product(productImage[i],productTitle[i],productDescription[i])
            productList.add(product)
        }
        var adapter = ProductAdapter(productList)

        recyclerView.adapter =adapter
        adapter.onProductClickListener(object :ProductAdapter.onProductClickListener{
            override fun onProductClick(position: Int) {
                    val intent = Intent(this@MainActivity,ProductDisplay::class.java)
                    intent.putExtra("productTitle",productList[position].product_title)
                    intent.putExtra("productImage",productList[position].product_image)
                    intent.putExtra("productDescription",productList[position].product_description)
                    startActivity(intent)
            }

        })
    }
}