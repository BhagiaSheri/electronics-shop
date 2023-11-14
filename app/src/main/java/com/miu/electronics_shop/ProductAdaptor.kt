package com.miu.electronics_shop

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>,
    private val onItemClick: (Product) -> Unit,
    private val onAddToCartClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view, onAddToCartClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
        holder.itemView.setOnClickListener { onItemClick(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View, private val onAddToCartClick: (Product) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        private val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        private val productLogoImageView: ImageView = itemView.findViewById(R.id.productLogoImageView)
        private val productCostTextView: TextView = itemView.findViewById(R.id.productCostTextView)
        private val addToCartBtn: Button = itemView.findViewById(R.id.addToCartBtn)

        fun bind(product: Product) {
            productNameTextView.text = product.productName
            productDescriptionTextView.text = product.productDescription
            productImageView.setImageResource(product.productImage)
            productLogoImageView.setImageResource(product.productLogo)
            productCostTextView.text = "$${product.cost}"

            addToCartBtn.setOnClickListener { onAddToCartClick(product) }
        }
    }
}
