package com.app.amrescuer.utils

import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.app.amrescuer.R
import com.squareup.picasso.Picasso

class BindableObject
{
companion object{
@BindingAdapter("feedimg")
@JvmStatic
fun feedingImg(img:ImageView,url:String)
{
    Picasso.get().load("https://ukfashion.000webhostapp.com/am_secure/${url}").fit().error(R.drawable.place_holder).into(img)
}
}
}