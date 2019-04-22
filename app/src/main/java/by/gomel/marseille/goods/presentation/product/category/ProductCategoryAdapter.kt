package by.gomel.marseille.goods.presentation.product.category

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.presentation.base.recycler.BaseRecyclerViewAdapter
import by.gomel.marseille.goods.presentation.base.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.service_category_grid_item.view.*


class ProductCategoryAdapter : BaseRecyclerViewAdapter<ProductCategory, ProductCategoryAdapter.ProductCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_category_item, parent, false)
        return ProductCategoryViewHolder(itemView)
    }

    class ProductCategoryViewHolder(itemView: View) : BaseViewHolder<ProductCategory>(itemView) {
        private val nameTV = itemView.name_text_view

        override fun bindData(data: ProductCategory) {
            super.bindData(data)
            nameTV.text = data.title
        }
    }

}