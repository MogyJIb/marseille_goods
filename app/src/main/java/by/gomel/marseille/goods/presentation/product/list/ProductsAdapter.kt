package by.gomel.marseille.goods.presentation.product.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.presentation.base.recycler.BaseRecyclerViewAdapter
import by.gomel.marseille.goods.presentation.base.recycler.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductAdapter : BaseRecyclerViewAdapter<Product, ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(itemView)
    }

    class ProductViewHolder(itemView: View) : BaseViewHolder<Product>(itemView) {

        private val nameTV = itemView.product_name
        private val priceTV = itemView.product_price
        private val iconIV = itemView.product_icon

        override fun bindData(data: Product) {
            super.bindData(data)

            nameTV.text = data.name
            priceTV.text = "${data.price} BIN"

            runCatching {
                Glide.with(itemView)
                    .load(data.imageUrl)
                    .into(iconIV)
            }
        }

    }
}