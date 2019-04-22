package by.gomel.marseille.goods.presentation

import android.os.Bundle
import by.gomel.marseille.goods.presentation.base.view.BaseFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.LinearLayout
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Toast
import by.gomel.marseille.goods.R
import android.widget.TextView
import by.gomel.marseille.goods.domain.extentions.dp
import android.widget.ImageView


abstract class BaseMainFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (activity !is MainActivity) throw IllegalStateException("BaseMainFragment should be used only for MainActivity")
        bottomBarButton().setOnClickListener(null)
        super.onCreate(savedInstanceState)
    }

    fun bottomBar(): BottomAppBar = (activity as MainActivity).bottomBar()
    fun bottomBarButton(): FloatingActionButton = (activity as MainActivity).bottomBarButton()
    fun setTitle(title: String) = (activity as MainActivity).setTitle(title)

    override fun toast(text: String)
            = Toast.makeText(context, text, Toast.LENGTH_LONG).apply {
                setGravity(Gravity.CENTER, 0, (-200).dp)

                val toastView = view as LinearLayout
                toastView.setBackgroundResource(R.drawable.background_toast)
//                toastView.addView(
//                    ImageView(context).apply {
//                        scaleType = ImageView.ScaleType.FIT_CENTER
//                        setImageResource(R.drawable.marseille_logo)
//                        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200.dp)
//                    }, 0
//                )

                val toastMessage = toastView.findViewById(android.R.id.message) as TextView
                toastMessage.textSize = 16f
                toastMessage.setTextColor(resources.getColor(R.color.text_primary_inverse))
                toastMessage.gravity = Gravity.CENTER
                toastMessage.setPadding(16.dp, 32.dp, 16.dp, 32.dp)
            }
            .show()

}