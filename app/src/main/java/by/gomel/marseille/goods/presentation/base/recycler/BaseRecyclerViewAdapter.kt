package by.gomel.marseille.goods.presentation.base.recycler

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.gomel.marseille.goods.presentation.base.OnClickListener
import by.gomel.marseille.goods.presentation.base.OnLongClickListener

abstract class BaseRecyclerViewAdapter<T : Any, H : BaseViewHolder<T>>(
        protected var items: MutableList<T> = mutableListOf<T>()
) : RecyclerView.Adapter<H>() {

    var onClickListener: OnClickListener<T>? = null
    var onLongClickListener: OnLongClickListener<T>? = null

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.onClickListener = onClickListener
        holder.onLongClickListener = onLongClickListener
        holder.bindData(items[position])
    }

    override fun onViewDetachedFromWindow(holder: H) {
        holder.release()
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount() = items.size

    open fun updateItems(items: List<T>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(this.items, items))
        this.items = items.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

    open fun clear() {
        this.items = mutableListOf()
        notifyDataSetChanged()
    }

    open fun removeItem(item: T) {
        val position = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(position)
    }

    open fun addItem(item: T) {
        items.add(item)
        val position = items.indexOf(item)
        notifyItemInserted(position)
    }

}
