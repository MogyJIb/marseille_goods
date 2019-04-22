package by.gomel.marseille.goods.domain.extentions

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


fun <T> RequestBuilder<T>.load(url: String, onResourceReady: (T) -> Unit)
    = this.load(url)
        .into(object : CustomTarget<T>() {

            override fun onResourceReady(resource: T, transition: Transition<in T>?) {
                onResourceReady(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {}

        })