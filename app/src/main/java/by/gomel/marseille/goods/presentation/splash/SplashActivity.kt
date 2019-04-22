package by.gomel.marseille.goods.presentation.splash

import android.os.Bundle
import androidx.navigation.Navigation
import by.gomel.marseille.goods.presentation.base.view.BaseActivity
import by.gomel.marseille.goods.R


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.splash_nav_host_fragment)

}

