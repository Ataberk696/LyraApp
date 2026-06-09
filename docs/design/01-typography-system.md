# LyraApp - Tipografi Sistemi

> Bu dosya LyraApp isimli uygulamanın tipografi ölçeği için
> **tek doğruluk kaynağıdır** (single source of truth) ve
> doğrudan bir **Android Jetpack Compose** projesinde kullanılmak
> üzere düzenlenmiştir.

---

## 1. Temel Kural

> Hiçbir `@Composable` içinde ham `fontSize`, `fontWeight`, `lineHeight`
> gibi tipografi değerleri yazılmaz.
> Tipler daima `MaterialTheme.typography.<slot>` üzerinden
> okunmak zorundadır.

Ham `TextStyle(..)` tanımı yalnızca `Type.kt` içinde, sabit değişken
tanımlanırken kullanılır.

---

## 2. Font Ailesi

LyraApp yalnızca **Roboto** font ailesini kullanır.
Roboto, Android sisteminde yerleşik olarak bulunduğundan ek bağımlılık
gerekmez; `FontFamily.Default` doğrudan Roboto'ya karşılık gelir.

| Ağırlık Sabiti    | `FontWeight` Değeri | Kullanım Amacı                   |
| ----------------- | ------------------- | -------------------------------- |
| `Roboto_Light`    | `FontWeight(300)`   | Büyük görsel başlıklar           |
| `Roboto_Regular`  | `FontWeight(400)`   | Gövde metni, açıklamalar         |
| `Roboto_Medium`   | `FontWeight(500)`   | Bölüm etiketleri, tab başlıkları |
| `Roboto_SemiBold` | `FontWeight(600)`   | Kart başlıkları, lisans adları   |
| `Roboto_Bold`     | `FontWeight(700)`   | Ekran başlıkları, CTA butonları  |

---

## 3. `Type.kt` — TextStyle Token Tanımları

```kotlin
package com.lyraapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ── FONT AĞIRLIKLARI ──
// Roboto Android'de yerleşiktir; FontFamily.Default = Roboto.
private val Roboto_Light    = FontFamily.Default  // weight ile birlikte kullanılır
private val Roboto_Regular  = FontFamily.Default
private val Roboto_Medium   = FontFamily.Default
private val Roboto_SemiBold = FontFamily.Default
private val Roboto_Bold     = FontFamily.Default

// ── LYRA TİPOGRAFİ ÖLÇEĞİ ──
// M3 slot adları korunur; yalnızca boyut / ağırlık / satır-yüksekliği
// bu dosyada sabitlenir.

val LyraTypography = Typography(

    // ── Display ──
    // Büyük karşılama ekranları, hero alanlar
    displayLarge = TextStyle(
        fontFamily = Roboto_Light,
        fontWeight = FontWeight(300),
        fontSize   = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    displayMedium = TextStyle(
        fontFamily = Roboto_Light,
        fontWeight = FontWeight(300),
        fontSize   = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = Roboto_Regular,
        fontWeight = FontWeight(400),
        fontSize   = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),

    // ── Headline ──
    // Ekran başlıkları (NowPlaying, Playlist, Album detay vb.)
    headlineLarge = TextStyle(
        fontFamily = Roboto_SemiBold,
        fontWeight = FontWeight(600),
        fontSize   = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Roboto_SemiBold,
        fontWeight = FontWeight(600),
        fontSize   = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = Roboto_SemiBold,
        fontWeight = FontWeight(600),
        fontSize   = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),

    // ── Title ──
    // Kart başlıkları, şarkı adı (player bar), bölüm başlıkları
    titleLarge = TextStyle(
        fontFamily = Roboto_Bold,
        fontWeight = FontWeight(700),
        fontSize   = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Roboto_Medium,
        fontWeight = FontWeight(500),
        fontSize   = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = Roboto_Medium,
        fontWeight = FontWeight(500),
        fontSize   = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),

    // ── Body ──
    // Açıklamalar, şarkı sözleri, genel içerik metinleri
    bodyLarge = TextStyle(
        fontFamily = Roboto_Regular,
        fontWeight = FontWeight(400),
        fontSize   = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Roboto_Regular,
        fontWeight = FontWeight(400),
        fontSize   = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = Roboto_Regular,
        fontWeight = FontWeight(400),
        fontSize   = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),

    // ── Label ──
    // Buton etiketleri, chip'ler, zaman damgaları, navigation bar ikonları
    labelLarge = TextStyle(
        fontFamily = Roboto_Medium,
        fontWeight = FontWeight(500),
        fontSize   = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Roboto_Medium,
        fontWeight = FontWeight(500),
        fontSize   = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = Roboto_Medium,
        fontWeight = FontWeight(500),
        fontSize   = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)
```

---

## 4. `Theme.kt` Entegrasyonu

`LyraTypography`, `Theme.kt` içindeki `MaterialTheme` çağrısına
`typography` parametresi olarak iletilir.
Renk sisteminde olduğu gibi bu atama **zaten** `Theme.kt` içinde
mevcuttur; `Type.kt` güncellendiğinde otomatik olarak devreye girer.

```kotlin
MaterialTheme(
    colorScheme = colorScheme,
    typography  = LyraTypography, // Type.kt'deki nesneyi okur
    content     = content,
)
```

---

## 5. Slot Kullanım Rehberi

Aşağıdaki tablo, LyraApp ekranlarındaki UI öğelerinin hangi tipografi
slot'unu kullanması gerektiğini tanımlar.

| UI Öğesi                          | Önerilen Slot    |
| --------------------------------- | ---------------- |
| Karşılama / hero başlık           | `displaySmall`   |
| Ekran başlığı (TopAppBar)         | `headlineSmall`  |
| Playlist / albüm adı (büyük kart) | `headlineMedium` |
| Şarkı adı (NowPlaying ekranı)     | `titleLarge`     |
| Sanatçı adı (NowPlaying ekranı)   | `titleMedium`    |
| Kart başlığı (küçük)              | `titleSmall`     |
| Şarkı sözleri, açıklama metni     | `bodyMedium`     |
| İkincil açıklama, süre bilgisi    | `bodySmall`      |
| Buton etiketi                     | `labelLarge`     |
| Navigation bar öğe etiketi        | `labelMedium`    |
| Zaman damgası, rozet metni        | `labelSmall`     |

---
