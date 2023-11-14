package com.miu.electronics_shop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.electronics_shop.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Receive product details from intent
        val product = intent.getSerializableExtra("product") as Product
        displayProductDetails(product)

        binding.returnHomeButton.setOnClickListener {
            returnHome()
        }
    }

    private fun displayProductDetails(product: Product) {
        binding.productNameTextView.text = product.productName
        binding.productDescriptionTextView.text = product.productDescription
        binding.productImageView.setImageResource(product.productImage)
        binding.productCostTextView.text = "$${product.cost}"
    }

    private fun returnHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Optional: Finish the details activity to remove it from the back stack
    }
}
