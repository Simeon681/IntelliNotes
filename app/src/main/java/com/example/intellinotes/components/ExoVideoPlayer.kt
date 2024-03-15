@file:Suppress("DEPRECATION")

package com.example.intellinotes.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

@Composable
fun ExoVideoPlayer(uri: String) {
    val context = LocalContext.current
    val exoPlayer = remember {getSimpleExoPlayer(context, uri)}
    AndroidView(
        modifier = Modifier
            .fillMaxSize(),
        factory = { context1 ->
            PlayerView(context1).apply {
                player = exoPlayer
            }
        },
    )
}
private fun getSimpleExoPlayer(context: Context, uri: String): SimpleExoPlayer {
    return SimpleExoPlayer.Builder(context).build().apply {
        val dataSourceFactory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, context.packageName)
        )
        //local video
        val localVideoItem = MediaItem.fromUri(uri.toUri())
        val localVideoSource = ProgressiveMediaSource
            .Factory(dataSourceFactory)
            .createMediaSource(localVideoItem)
        this.addMediaSource(localVideoSource)
        // init
        this.prepare()
    }
}