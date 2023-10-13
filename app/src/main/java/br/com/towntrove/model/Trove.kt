package br.com.towntrove.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Trove(
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageDrawable: Int
)
data class Coffee(@DrawableRes val imageCoffe: Int)

data class Restaurante(@DrawableRes val imageRestaurante: Int)

data class Parque(@DrawableRes val imageParque: Int)

