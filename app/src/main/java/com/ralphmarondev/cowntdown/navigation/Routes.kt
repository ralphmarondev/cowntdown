package com.ralphmarondev.cowntdown.navigation

import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object Home

    @Serializable
    data object Moo

    @Serializable
    data object Settings
}