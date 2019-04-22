package by.gomel.marseille.goods.presentation

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import by.gomel.marseille.goods.R
import kotlinx.android.synthetic.main.dialog_info.*


class InfoDialog: DialogFragment(), DialogInterface {
    var leftButtonListener: DialogInterface.OnClickListener? = null
    var rightButtonListener: DialogInterface.OnClickListener? = null

    var customView: View? = null

    companion object {
        @JvmStatic
        fun newInstance(
                title: String? = null,
                message: String? = null,
                leftButtonCaption: String? = null,
                rightButtonCaption: String? = null

        ) = InfoDialog().apply {
            arguments = bundleOf(
                    "TITLE" to title,
                    "MESSAGE" to message,
                    "LEFT_CAPTION" to leftButtonCaption,
                    "RIGHT_CAPTION" to rightButtonCaption
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Widget_AppTheme_Dialog)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.dialog_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            args.getString("TITLE")?.let { title -> dialog_title.textVisible(title) }
            args.getString("MESSAGE")?.let { message -> dialog_message.textVisible(message) }
            args.getString("LEFT_CAPTION")?.let { leftCaption -> button_left.textVisible(leftCaption) }
            args.getString("RIGHT_CAPTION")?.let { rightCaption -> button_right.textVisible(rightCaption) }
        }

        customView?.run {
            custom_view_layout .removeAllViews()
            custom_view_layout.addView(this, 0)
        }

        button_left.setOnClickListener {
            leftButtonListener?.run {
                onClick(this@InfoDialog, DialogInterface.BUTTON_NEGATIVE)
            }
            dismiss()
        }

        button_right.setOnClickListener {
            rightButtonListener?.run {
                onClick(this@InfoDialog, DialogInterface.BUTTON_POSITIVE)
            }
            dismiss()
        }
    }

    override fun onDestroy() {
        leftButtonListener = null
        rightButtonListener = null
        customView = null
        super.onDestroy()

    }

    override fun cancel() = dismiss()

    private fun TextView.textVisible(text: CharSequence) {
        this.visibility = View.VISIBLE
        this.text = text
    }


}
