package com.turkcell.lyraapp.data.mock

import com.turkcell.lyraapp.data.model.Category
import com.turkcell.lyraapp.data.model.Playlist
import com.turkcell.lyraapp.data.model.Song
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockRepository @Inject constructor() {

    fun getCategories(): List<Category> = listOf(
        Category(
            id = "1",
            title = "Gece Sürüşü",
            imageUrl = "https://via.placeholder.com/150/7C3AED/FFFFFF?text=Gece+Sürüşü",
            color = "#7C3AED"
        ),
        Category(
            id = "2",
            title = "Sabah Kahvesi",
            imageUrl = "https://via.placeholder.com/150/A855F7/FFFFFF?text=Sabah+Kahvesi",
            color = "#A855F7"
        ),
        Category(
            id = "3",
            title = "Neon Sokaklar",
            imageUrl = "https://via.placeholder.com/150/FB923C/FFFFFF?text=Neon+Sokaklar",
            color = "#FB923C"
        ),
        Category(
            id = "4",
            title = "Odaklan",
            imageUrl = "https://via.placeholder.com/150/14B8A6/FFFFFF?text=Odaklan",
            color = "#14B8A6"
        ),
        Category(
            id = "5",
            title = "Derin Mavi",
            imageUrl = "https://via.placeholder.com/150/22C55E/FFFFFF?text=Derin+Mavi",
            color = "#22C55E"
        ),
        Category(
            id = "6",
            title = "Yaz Anıları",
            imageUrl = "https://via.placeholder.com/150/06B6D4/FFFFFF?text=Yaz+Anıları",
            color = "#06B6D4"
        )
    )

    fun getRecentlyPlayed(): List<Playlist> = listOf(
        Playlist(
            id = "r1",
            title = "Neon Sokaklar",
            description = "Şehir Işıkları",
            imageUrl = "https://via.placeholder.com/300/FB923C/FFFFFF?text=Neon+Sokaklar",
            songCount = 45,
            author = "Çalma Listesi"
        ),
        Playlist(
            id = "r2",
            title = "Derin Mavi",
            description = "Okyanus",
            imageUrl = "https://via.placeholder.com/300/22C55E/FFFFFF?text=Derin+Mavi",
            songCount = 32,
            author = "Çalma Listesi"
        ),
        Playlist(
            id = "r3",
            title = "Yıldız Toz",
            description = "Polaris",
            imageUrl = "https://via.placeholder.com/300/06B6D4/FFFFFF?text=Yıldız+Toz",
            songCount = 28,
            author = "Çalma Listesi"
        ),
        Playlist(
            id = "r4",
            title = "Gece Sürüşü",
            description = "Rüya Yolu",
            imageUrl = "https://via.placeholder.com/300/7C3AED/FFFFFF?text=Gece+Sürüşü",
            songCount = 51,
            author = "Çalma Listesi"
        )
    )

    fun getPlaylistsForYou(): List<Playlist> = listOf(
        Playlist(
            id = "p1",
            title = "Ruh Yolculuğu",
            description = "Meditasyon Müziği",
            imageUrl = "https://via.placeholder.com/300/A855F7/FFFFFF?text=Ruh+Yolculuğu",
            songCount = 38,
            author = "Lyra Seçkisi"
        ),
        Playlist(
            id = "p2",
            title = "Elektrik Kalp",
            description = "Elektronik Müzik",
            imageUrl = "https://via.placeholder.com/300/7C3AED/FFFFFF?text=Elektrik+Kalp",
            songCount = 44,
            author = "Lyra Seçkisi"
        ),
        Playlist(
            id = "p3",
            title = "Gökyüzü Hayal",
            description = "Ambient Atmosfer",
            imageUrl = "https://via.placeholder.com/300/06B6D4/FFFFFF?text=Gökyüzü+Hayal",
            songCount = 35,
            author = "Lyra Seçkisi"
        ),
        Playlist(
            id = "p4",
            title = "Enerji Dalgası",
            description = "Dans Müziği",
            imageUrl = "https://via.placeholder.com/300/14B8A6/FFFFFF?text=Enerji+Dalgası",
            songCount = 48,
            author = "Lyra Seçkisi"
        )
    )

    fun getSongsByCategory(categoryId: String): List<Song> = listOf(
        Song(
            id = "s1",
            title = "Gece Şarkısı",
            artist = "Müzisyen 1",
            imageUrl = "https://via.placeholder.com/150/7C3AED/FFFFFF?text=S1",
            duration = 240000L
        ),
        Song(
            id = "s2",
            title = "Sokak Işığı",
            artist = "Müzisyen 2",
            imageUrl = "https://via.placeholder.com/150/A855F7/FFFFFF?text=S2",
            duration = 210000L
        ),
        Song(
            id = "s3",
            title = "Rüya Dansı",
            artist = "Müzisyen 3",
            imageUrl = "https://via.placeholder.com/150/FB923C/FFFFFF?text=S3",
            duration = 280000L
        )
    )
}
