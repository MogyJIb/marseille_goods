package by.gomel.marseille.goods.presentation

import android.os.Bundle
import androidx.navigation.Navigation
import by.gomel.marseille.goods.presentation.base.view.BaseActivity
import by.gomel.marseille.goods.R
import by.gomel.marseille.goods.domain.ShoppingCart
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    val shoppingCart: ShoppingCart by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_app_bar.setNavigationOnClickListener {
            //MainMenuDialogFragment().show(supportFragmentManager, MainMenuDialogFragment::javaClass.name)
        }
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.main_nav_host_fragment)

    fun setTitle(title: String) { category_title.text = title }
    fun bottomBar(): BottomAppBar = bottom_app_bar
    fun bottomBarButton(): FloatingActionButton = bottom_app_bar_button
}