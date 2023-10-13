package br.com.towntrove.data

import androidx.compose.ui.res.stringResource
import br.com.towntrove.R
import br.com.towntrove.R.drawable.*
import br.com.towntrove.model.Coffee
import br.com.towntrove.model.Parque
import br.com.towntrove.model.Restaurante
import br.com.towntrove.model.Trove

object LocalDataProvider{
    val data = listOf(
        Trove(
            titleResourceId = R.string.titulo,
            subtitleResourceId = R.string.apresentacao,
            imageDrawable = image1
        )  ,
        Trove(
            titleResourceId = R.string.explorar_titulo,
            subtitleResourceId = R.string.explorar_texto,
            imageDrawable = image2
        ) ,
        Trove(
            titleResourceId = R.string.recomendacao_titulo,
            subtitleResourceId = R.string.recomendacao_texto,
            imageDrawable = image3
        ),
    )

}

object DataCafe {
    val dataCoffee = listOf(
        Coffee(
            imageCoffe = cafetaria1
        ),
        Coffee(
            imageCoffe = cafetaria2
        ),
        Coffee(
            imageCoffe = cafetaria3
        ),
        Coffee(
            imageCoffe = cafetaria4
        )
    )
}
object DataRestaurante {
    val dataRestaurante = listOf(
        Restaurante(
            imageRestaurante = restaurante1
        ),
        Restaurante(
            imageRestaurante = restaurante2
        ),
        Restaurante(
            imageRestaurante = restaurante3
        ),
        Restaurante(
            imageRestaurante = restaurante4
        )
    )
}

object DataParque {
    val dataParque = listOf(
        Parque(
            imageParque = parque1
        ),
        Parque(
            imageParque = parque2
        ),
        Parque(
            imageParque = parque3
        ),
        Parque(
            imageParque = parque4
        )
    )
}

