package com.miu.electronics_shop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.electronics_shop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val products = ArrayList<Product>()
    private val cartItems = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize product list
        initProductList()

        // Set up RecyclerView
        val adapter = ProductAdapter(products, this::showProductDetails, this::addToCart)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.viewCartBtn.setOnClickListener { viewCart() }
    }

    private fun initProductList() {
        products.add(
            Product(
                "iPad",
                "iPad Pro 11-inch",
                R.drawable.ic_ipad,
                R.drawable.ic_logo_mac,
                400.0
            )
        )
        products.add(
            Product(
                "MacBook M3 Pro",
                "12-core CPU\n18-core GPU",
                R.drawable.ic_macbook,
                R.drawable.ic_logo_mac,
                2500.00
            )
        )
        products.add(
            Product(
                "Dell Inspiron",
                "13th Gen Intel® Core™ i7",
                R.drawable.ic_dell,
                R.drawable.ic_logo_dell,
                1499.00
            )
        )
        products.add(
            Product(
                "Logitech Keyboard",
                "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                R.drawable.ic_logitech,
                R.drawable.ic_logo_logitech,
                199.00
            )
        )
        products.add(
            Product(
                "MacBook M3 Max",
                "14-core CPU\n30-core GPU",
                R.drawable.ic_macbook,
                R.drawable.ic_logo_mac,
                3499.00
            )
        )
    }

    private fun showProductDetails(product: Product) {
        val detailsText =
            "Product Name: ${product.productName}\nProduct Description: ${product.productDescription}"
        Toast.makeText(this, detailsText, Toast.LENGTH_LONG).show()

        // Launch ProductDetailsActivity when an item is clicked
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("product", product)
        this.startActivity(intent)
    }

    private fun addToCart(product: Product) {
        cartItems.add(product)
        Toast.makeText(this, "Added ${product.productName} to Cart", Toast.LENGTH_SHORT).show()
    }

    private fun viewCart() {
        val cartItemsText = cartItems.joinToString(separator = "\n") { it.productName }
        AlertDialog.Builder(this)
            .setTitle("Cart Items")
            .setMessage(cartItemsText)
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
