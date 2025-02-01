package com.ralphmarondev.cowntdown.navigation

import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object Onboarding

    @Serializable
    data object Main

    @Serializable
    data object Home

    @Serializable
    data object Moo

    @Serializable
    data object Settings

    @Serializable
    data object About

    @Serializable
    data object Developer

    @Serializable
    data object Licenses
}