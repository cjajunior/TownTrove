package br.com.towntrove.model

import androidx.annotation.StringRes

data class Trove(
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
)
