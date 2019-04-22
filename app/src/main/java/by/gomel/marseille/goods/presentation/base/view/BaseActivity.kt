package by.gomel.marseille.goods.presentation.base.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.gomel.marseille.goods.domain.extentions.log

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun context() = this

    override fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        javaClass.log("onCreate")
    }

    override fun onStart() {
        super.onStart()
        javaClass.log("onStart")
    }

    override fun onResume() {
        super.onResume()
        javaClass.log("onResume")
    }

    override fun onPause() {
        super.onPause()
        javaClass.log("onPause")
    }

    override fun onStop() {
        super.onStop()
        javaClass.log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        javaClass.log("onDestroy")
    }
}