package br.com.towntrove.ui

sealed class NavScreens(val route: String) {
    object Inicio: NavScreens("inicio")
    object Detalhes: NavScreens("detalhes")
    object DetalhesCafe : NavScreens("detalhesCafe")
    object Principal: NavScreens("principal")
}