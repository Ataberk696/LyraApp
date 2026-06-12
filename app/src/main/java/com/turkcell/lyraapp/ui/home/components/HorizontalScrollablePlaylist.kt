package com.turkcell.lyraapp.ui.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.turkcell.lyraapp.data.model.Playlist

@Composable
fun HorizontalScrollablePlaylist(
    playlists: List<Playlist>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.width(12.dp))

        playlists.forEach { playlist ->
            PlaylistCard(
                playlist = playlist,
                onClick = {}
            )
        }

        Spacer(modifier = Modifier.width(12.dp))
    }
}
