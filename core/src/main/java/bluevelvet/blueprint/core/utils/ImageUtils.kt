package bluevelvet.blueprint.core.utils

import android.widget.ImageView
import bluevelvet.blueprint.style.R
import com.bumptech.glide.Glide

object ImageUtils {
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .centerCrop()
            .placeholder(R.mipmap.img_place_holder)
            .error(R.mipmap.img_place_holder)
            .into(view)
    }
}