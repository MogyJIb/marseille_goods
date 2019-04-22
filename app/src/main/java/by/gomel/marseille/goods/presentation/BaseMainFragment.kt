package by.gomel.marseille.goods.presentation

import android.os.Bundle
import by.gomel.marseille.goods.presentation.base.view.BaseFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

abstract class BaseMainFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (activity !is MainActivity) throw IllegalStateException("BaseMainFragment should be used only for MainActivity")
        bottomBarButton().setOnClickListener(null)
        super.onCreate(savedInstanceState)
    }

    fun bottomBar(): BottomAppBar = (activity as MainActivity).bottomBar()
    fun bottomBarButton(): FloatingActionButton = (activity as MainActivity).bottomBarButton()
    fun setTitle(title: String) = (activity as MainActivity).setTitle(title)
}