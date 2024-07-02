package com.sample.compose_bs_android2.mine.mutex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.compose_bs_android2.mine.mutex.real.RealMutexScreen
import com.sample.compose_bs_android2.mine.mutex.simple.SimpleMutexScreen

@Composable
fun MutualExclusionScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MutexRoute.Home
    ) {

        composable<MutexRoute.Home> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { navController.navigate(MutexRoute.Simple) }) {
                    Text("Simple Mutex")
                }
                Button(onClick = { navController.navigate(MutexRoute.Real) }) {
                    Text("Real Mutex")
                }
            }
        }
        composable<MutexRoute.Simple> {
            SimpleMutexScreen()
        }

        composable<MutexRoute.Real> {
            RealMutexScreen()
        }
    }


}


@Preview
@Composable
private fun MutualExclusionScreenPreview() {
    MutualExclusionScreen()
}

//

/// references
// https://www.youtube.com/watch?v=RGtZXBm30RQ