package by.gomel.marseille.goods.presentation.cart

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.data.models.CartDto
import by.gomel.marseille.goods.presentation.base.recycler.BaseRecyclerViewAdapter
import by.gomel.marseille.goods.presentation.base.recycler.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cart_list_item.view.*
import org.koin.standalone.inject


class CartAdapter : BaseRecyclerViewAdapter<CartDto, CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_list_item, parent, false)
        return CartViewHolder(itemView) { item: CartDto -> removeItem(item) }
    }

    class CartViewHolder(
            itemView: View,
            private val onRemove: (item: CartDto) -> Unit
    ) : BaseViewHolder<CartDto>(itemView) {

        override val presenter: CartItemContract.Presenter by inject()

        private val isAdd = itemView.is_add_check_box
        private val productName = itemView.product_name
        private val productPrice = itemView.product_price
        private val counter = itemView.counter_text_view
        private val incrementButton = itemView.button_increment_counter
        private val decrementButton = itemView.button_decrement_counter
        private val iconIV = itemView.product_icon
        private val removeButton = itemView.remove_product_button

        override fun bindData(data: CartDto) {
            super.bindData(data)

            isAdd.isChecked = data.checked
            isAdd.setOnCheckedChangeListener { _, isChecked ->
                data.checked = isChecked
                presenter.updateCartWithItem(data)
            }
            productName.text = data.product.name
            updateCount()

            incrementButton.setOnClickListener {
                data.count++
                updateCount()
            }

            decrementButton.setOnClickListener {
                if (data.count > 1) {
                    data.count--
                    updateCount()
                }
            }

            removeButton.setOnClickListener {
                presenter.onItemDeleteButtonClicked(data)
                onRemove(data)
            }

            runCatching {
                Glide.with(itemView)
                    .load(data.product.imageUrl)
                    .into(iconIV)
            }

        }

        private fun updateCount() {
            productPrice.text = "${data.totalPrice} BIN"
            counter.text = data.count.toString()
            presenter.updateCartWithItem(data)
        }

    }
}