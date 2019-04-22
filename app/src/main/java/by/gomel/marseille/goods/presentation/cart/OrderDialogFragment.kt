package by.gomel.marseille.goods.presentation.cart

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.presentation.base.view.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_order.*

class OrderDialogFragment : BaseDialogFragment(), DialogInterface {
    var leftButtonListener: DialogInterface.OnClickListener? = null
    var rightButtonListener: DialogInterface.OnClickListener? = null

    companion object {
        @JvmStatic fun newInstance() = OrderDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Widget_AppTheme_Dialog)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.dialog_order, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        button_left.setOnClickListener {
            leftButtonListener?.run {
                onClick(this@OrderDialogFragment, DialogInterface.BUTTON_NEGATIVE)
            }
            dismiss()
        }

        button_right.setOnClickListener {
            rightButtonListener?.run {
                onClick(this@OrderDialogFragment, DialogInterface.BUTTON_POSITIVE)
            }
            dismiss()
        }
    }

    override fun onDestroy() {
        leftButtonListener = null
        rightButtonListener = null
        super.onDestroy()

    }

    override fun cancel() = dismiss()

}