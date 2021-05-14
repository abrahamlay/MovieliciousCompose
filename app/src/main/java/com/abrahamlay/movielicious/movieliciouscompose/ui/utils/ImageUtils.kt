package com.abrahamlay.movielicious.movieliciouscompose.ui.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.abrahamlay.movielicious.movieliciouscompose.config.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@Composable
fun loadPicture(url: String?, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {
    var addedUrl = url
    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)
    if (!url.isNullOrEmpty()) {
        addedUrl =
            if (!url.contains("https://") || !url.contains("http://")) String.format(
                Constants.MOVIE_THUMBNAIL_BASE_URL_MEDIUM,
                url
            ) else url
    }
    // show default image while image loads
    Glide.with(LocalContext.current)
            .asBitmap()
            .load(defaultImage)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) { }
                override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                ) {
                    bitmapState.value = resource
                }
            })

    // get network image
    Glide.with(LocalContext.current)
            .asBitmap()
            .load(addedUrl)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) { }
                override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                ) {
                    bitmapState.value = resource
                }
            })

    return bitmapState
}



@ExperimentalCoroutinesApi
@Composable
fun loadPicture(@DrawableRes drawable: Int): MutableState<Bitmap?> {

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(drawable)
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) { }
            override fun onResourceReady(
                resource: Bitmap,
                transition: Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }
        })

    return bitmapState
}













