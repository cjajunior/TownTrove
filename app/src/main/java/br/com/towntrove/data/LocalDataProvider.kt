package br.com.towntrove.data

import androidx.annotation.StringRes
import br.com.towntrove.R
import br.com.towntrove.model.Trove

object LocalDataProvider{
    val data = listOf(
        Trove(
            titleResourceId = R.string.titulo,
            subtitleResourceId = R.string.apresentacao
        )
    )

}
