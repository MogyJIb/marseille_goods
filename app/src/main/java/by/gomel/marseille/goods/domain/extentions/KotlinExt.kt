package by.gomel.marseille.goods.domain.extentions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import com.google.android.material.textfield.TextInputLayout
import java.util.*


fun IntRange.rand() = Random().nextInt((endInclusive + 1) - start) + start

fun View.findNavController() = Navigation.findNavController(this)

fun fragmentNavigatorExtras(vararg sharedElements: Pair<View, String>) =
        FragmentNavigator.Extras.Builder().apply {
            sharedElements.forEach { (view, name) ->
                addSharedElement(view, name)
            }
        }.build()

fun View.hide() = let { visibility = View.GONE }
fun View.show() = let { visibility = View.VISIBLE }
fun View.isVisible() = visibility == View.VISIBLE

fun View.enable() = let { isEnabled = true }
fun View.disable() = let { isEnabled = false }

fun TextInputLayout.showError(@StringRes errorRes: Int) = run { error = context.getString(errorRes) }
fun TextInputLayout.hideError() = run { isErrorEnabled = false }

fun <T> Class<T>.log(message: String) = Log.d(simpleName, message)

fun px(dp: Int) = (dp * Resources.getSystem().displayMetrics.density).toInt()
fun dp(px: Int) = (px / Resources.getSystem().displayMetrics.density).toInt()

fun Activity.hideKeyboard() {
    currentFocus?.let { focused ->
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(focused.windowToken, 0)
    }
}


fun Context.toast(message: Int) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun notNull(vararg values: Any?, action: () -> Unit) {
    values.forEach { it ?: return }
    action()
}