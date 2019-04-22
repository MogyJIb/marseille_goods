package by.gomel.marseille.goods.presentation.base.recycler

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import by.gomel.marseille.goods.presentation.base.OnClickListener
import by.gomel.marseille.goods.presentation.base.OnLongClickListener
import by.gomel.marseille.goods.presentation.base.view.BaseContract
import org.koin.standalone.KoinComponent


abstract class BaseViewHolder<T : Any>(
        itemView: View
) : RecyclerView.ViewHolder(itemView), BaseContract.View, KoinComponent {

    protected open val presenter: BaseContract.Presenter? = null
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
        presenter?.bind(this)
    }

    open fun release() {
        itemView.setOnClickListener(null)
        itemView.setOnLongClickListener(null)
        presenter?.unbind()
    }

    override fun context():Context = itemView.context
    override fun router(): NavController = Navigation.findNavController(itemView)

    override fun toast(text: String) = Toast.makeText(context(), text, Toast.LENGTH_LONG).show()


}