package com.bap.musicapp.ui.screens

import androidx.annotation.DrawableRes
import com.bap.musicapp.R

sealed class Screen(val tile: String, val route: String) {

    sealed class DrawerScreen(val dTile: String, val dRoute: String, @DrawableRes val icon: Int) : Screen(dTile, dRoute) {
        object Account: DrawerScreen(
            "Account",
            "account",
            R.drawable.ic_account
        )
        object Subscription: DrawerScreen(
            "Subscription",
            "subscribe",
            R.drawable.ic_subscribe
        )
        object AddAccount: DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.ic_baseline_person_add_alt_1_24
        )
    }
}

val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount,
)