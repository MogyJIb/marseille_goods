package by.gomel.marseille.goods.presentation.base.view

import android.widget.Toast
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment(), BaseContract.View {
    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

    override fun router() =
            if (activity is BaseActivity)
                (activity as BaseActivity).router()
            else
                throw IllegalStateException(
                        "Can't route BaseFragment in ${activity?.javaClass?.simpleName}." +
                                " Use only with BaseActivity instance."
                )

    override fun toast(text: String) = Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}