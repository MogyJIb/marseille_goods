package by.gomel.marseille.goods.presentation.base.recycler

import androidx.recyclerview.widget.DiffUtil


class DiffCallback(
        private val oldItems: List<*>,
        private val newItems: List<*>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size
    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldPos: Int, newPos: Int)
            = (oldItems[oldPos] == newItems[newPos])
    override fun areItemsTheSame(oldPos: Int, newPos: Int)
            = (oldItems[oldPos] === newItems[newPos])
}