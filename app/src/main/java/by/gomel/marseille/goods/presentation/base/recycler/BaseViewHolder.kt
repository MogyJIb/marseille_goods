package by.gomel.marseille.goods.presentation.base.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.gomel.marseille.goods.presentation.base.OnClickListener
import by.gomel.marseille.goods.presentation.base.OnLongClickListener


abstract class BaseViewHolder<T : Any>(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {
    protected lateinit var data: T

    var onClickListener: OnClickListener<T>? = null
        set(value) {
            value?.let { listener ->
                itemView.setOnClickListener { listener(data) }
                field = listener
            }
        }

    var onLongClickListener: OnLongClickListener<T>? = null
        set(value) {
            value?.let { listener ->
                itemView.setOnLongClickListener { listener(data) }
                field = listener
            }
        }

    open fun bindData(data: T) {
        this.data = data
    }
}