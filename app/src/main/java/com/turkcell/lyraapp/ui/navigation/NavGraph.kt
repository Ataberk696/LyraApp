package com.turkcell.lyraapp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.turkcell.lyraapp.ui.auth.login.LoginScreen
import com.turkcell.lyraapp.ui.auth.register.RegisterScreen
import com.turkcell.lyraapp.ui.components.BottomNavBar
import com.turkcell.lyraapp.ui.components.BottomNavItem
import com.turkcell.lyraapp.ui.favorites.FavoritesScreen
import com.turkcell.lyraapp.ui.home.HomeScreen
import com.turkcell.lyraapp.ui.icons.LyraIcons
import com.turkcell.lyraapp.ui.library.LibraryScreen
import com.turkcell.lyraapp.ui.profile.ProfileScreen
import com.turkcell.lyraapp.ui.search.SearchScreen

@Composable
fun LyraNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = LoginRoute,
        modifier = modifier
    ) {
        composable<LoginRoute> {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(RegisterRoute)
                },
                onNavigateToHome = {
                    navController.navigate(HomeRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                }
            )
        }
        
        composable<RegisterRoute> {
            RegisterScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToLogin = {
                    navController.navigate(LoginRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(HomeRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                }
            )
        }

        composable<HomeRoute> {
            MainScreen(navController = navController)
        }

        composable<SearchRoute> {
            MainScreen(
                initialTab = 1,
                navController = navController
            )
        }

        composable<LibraryRoute> {
            MainScreen(
                initialTab = 2,
                navController = navController
            )
        }

        composable<FavoritesRoute> {
            MainScreen(
                initialTab = 3,
                navController = navController
            )
        }

        composable<ProfileRoute> {
            MainScreen(
                initialTab = 4,
                navController = navController
            )
        }
    }
}

@Composable
private fun MainScreen(
    initialTab: Int = 0,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val selectedTab = remember { mutableIntStateOf(initialTab) }

    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            when (selectedTab.intValue) {
                0 -> HomeScreen()
                1 -> SearchScreen()
                2 -> LibraryScreen()
                3 -> FavoritesScreen()
                4 -> ProfileScreen()
            }
        }

        val bottomNavItems = listOf(
            BottomNavItem(
                label = "Ana sayfa",
                icon = LyraIcons.Home,
                isSelected = selectedTab.intValue == 0,
                onClick = {
                    selectedTab.intValue = 0
                    navController.navigate(HomeRoute) {
                        popUpTo(HomeRoute) { inclusive = true }
                    }
                }
            ),
            BottomNavItem(
                label = "Ara",
                icon = LyraIcons.Search,
                isSelected = selectedTab.intValue == 1,
                onClick = {
                    selectedTab.intValue = 1
                    navController.navigate(SearchRoute) {
                        popUpTo(HomeRoute)
                    }
                }
            ),
            BottomNavItem(
                label = "Kütüphanesi",
                icon = LyraIcons.Library,
                isSelected = selectedTab.intValue == 2,
                onClick = {
                    selectedTab.intValue = 2
                    navController.navigate(LibraryRoute) {
                        popUpTo(HomeRoute)
                    }
                }
            ),
            BottomNavItem(
                label = "Favoriler",
                icon = LyraIcons.Heart,
                isSelected = selectedTab.intValue == 3,
                onClick = {
                    selectedTab.intValue = 3
                    navController.navigate(FavoritesRoute) {
                        popUpTo(HomeRoute)
                    }
                }
            ),
            BottomNavItem(
                label = "Profil",
                icon = LyraIcons.Profile,
                isSelected = selectedTab.intValue == 4,
                onClick = {
                    selectedTab.intValue = 4
                    navController.navigate(ProfileRoute) {
                        popUpTo(HomeRoute)
                    }
                }
            )
        )

        BottomNavBar(items = bottomNavItems)
    }
}
