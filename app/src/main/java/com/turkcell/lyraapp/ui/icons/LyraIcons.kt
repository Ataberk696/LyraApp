package com.turkcell.lyraapp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object LyraIcons {
    val LogoWaveform: ImageVector
        get() = ImageVector.Builder(
            name = "LogoWaveform",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.White),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(11f, 4f)
                lineTo(13f, 4f)
                lineTo(13f, 20f)
                lineTo(11f, 20f)
                close()

                moveTo(7f, 8f)
                lineTo(9f, 8f)
                lineTo(9f, 16f)
                lineTo(7f, 16f)
                close()

                moveTo(15f, 7f)
                lineTo(17f, 7f)
                lineTo(17f, 17f)
                lineTo(15f, 17f)
                close()

                moveTo(3f, 11f)
                lineTo(5f, 11f)
                lineTo(5f, 13f)
                lineTo(3f, 13f)
                close()

                moveTo(19f, 10f)
                lineTo(21f, 10f)
                lineTo(21f, 14f)
                lineTo(19f, 14f)
                close()
            }
        }.build()

    val Phone: ImageVector
        get() = ImageVector.Builder(
            name = "Phone",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(7f, 4f)
                lineTo(17f, 4f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 6f)
                lineTo(19f, 18f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17f, 20f)
                lineTo(7f, 20f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5f, 18f)
                lineTo(5f, 6f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 7f, 4f)
                close()

                moveTo(11f, 17f)
                lineTo(13f, 17f)
            }
        }.build()

    val Lock: ImageVector
        get() = ImageVector.Builder(
            name = "Lock",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(7f, 11f)
                lineTo(17f, 11f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 13f)
                lineTo(19f, 20f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17f, 22f)
                lineTo(7f, 22f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5f, 20f)
                lineTo(5f, 13f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 7f, 11f)
                close()

                moveTo(7f, 11f)
                lineTo(7f, 7f)
                arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17f, 7f)
                lineTo(17f, 11f)
            }
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(12f, 15f)
                arcTo(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10.5f, 16.5f)
                arcTo(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12f, 15f)
                close()
            }
        }.build()

    val Eye: ImageVector
        get() = ImageVector.Builder(
            name = "Eye",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(2f, 12f)
                curveTo(2f, 12f, 5f, 5f, 12f, 5f)
                curveTo(19f, 5f, 22f, 12f, 22f, 12f)
                curveTo(22f, 12f, 19f, 19f, 12f, 19f)
                curveTo(5f, 19f, 2f, 12f, 2f, 12f)
                close()

                moveTo(12f, 15f)
                arcTo(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 15f, 12f)
                arcTo(3f, 3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12f, 15f)
                close()
            }
        }.build()

    val ArrowRight: ImageVector
        get() = ImageVector.Builder(
            name = "ArrowRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(5f, 12f)
                lineTo(19f, 12f)
                moveTo(12f, 5f)
                lineTo(19f, 12f)
                lineTo(12f, 19f)
            }
        }.build()

    val ArrowLeft: ImageVector
        get() = ImageVector.Builder(
            name = "ArrowLeft",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(19f, 12f)
                lineTo(5f, 12f)
                moveTo(12f, 19f)
                lineTo(5f, 12f)
                lineTo(12f, 5f)
            }
        }.build()

    val Home: ImageVector
        get() = ImageVector.Builder(
            name = "Home",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(2f, 12f)
                lineTo(12f, 3f)
                lineTo(22f, 12f)
                lineTo(20f, 12f)
                lineTo(20f, 20f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 22f)
                lineTo(6f, 22f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 20f)
                lineTo(4f, 12f)
                lineTo(2f, 12f)
                close()
            }
        }.build()

    val Search: ImageVector
        get() = ImageVector.Builder(
            name = "Search",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(11f, 19f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 11f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11f, 3f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 11f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11f, 19f)
                close()

                moveTo(21f, 21f)
                lineTo(16.65f, 16.65f)
            }
        }.build()

    val Library: ImageVector
        get() = ImageVector.Builder(
            name = "Library",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(4f, 6f)
                lineTo(20f, 6f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 22f, 8f)
                lineTo(22f, 18f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 20f, 20f)
                lineTo(4f, 20f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 18f)
                lineTo(2f, 8f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 6f)
                close()

                moveTo(6f, 10f)
                lineTo(6f, 16f)
                moveTo(12f, 10f)
                lineTo(12f, 16f)
                moveTo(18f, 10f)
                lineTo(18f, 16f)
            }
        }.build()

    val Heart: ImageVector
        get() = ImageVector.Builder(
            name = "Heart",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(20.84f, 4.61f)
                arcTo(5.5f, 5.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.17f, 20.75f)
                lineTo(12f, 21.49f)
                lineTo(18.82f, 20.75f)
                arcTo(5.5f, 5.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 20.84f, 4.61f)
                close()
            }
        }.build()

    val Profile: ImageVector
        get() = ImageVector.Builder(
            name = "Profile",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(20f, 21f)
                lineTo(20f, 19f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 15f)
                lineTo(8f, 15f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = false, 4f, 19f)
                lineTo(4f, 21f)

                moveTo(12f, 11f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = false, 12f, 3f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = false, 12f, 11f)
                close()
            }
        }.build()
}
