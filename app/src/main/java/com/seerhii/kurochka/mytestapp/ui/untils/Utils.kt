package com.seerhii.kurochka.mytestapp.ui.untils

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size

    @Composable
    fun GifImage(
        modifier: Modifier = Modifier,
        imageID: Int
    ) {
        val context = LocalContext.current
        val imageLoader = ImageLoader.Builder(context)
            .components {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageID)
                    .apply<ImageRequest.Builder>(block = fun ImageRequest.Builder.() {
                        size(Size.ORIGINAL)
                    }).build(), imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

    }
