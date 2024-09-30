package com.sample.compose_bs_android2

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.sample.compose_bs_android2.approches.localComposition.LocalSpicyScreen
import com.sample.compose_bs_android2.ui.theme.ComposeBSAndroid2Theme

class MainActivity : FragmentActivity() {

    var currentIntent: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBSAndroid2Theme {
                Main(intent = intent)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        currentIntent = intent
        /// there is a problem here ...
        /// as when we receive new intent, we do not know how to pass it to the compose again
        /// because the onCreate function will not be called again.
    }
}


@Composable
fun Main(
    modifier: Modifier = Modifier,
    intent: Intent? = null
) {
    //TemplateScreen()
    //SharedElementScreen()
    //PullToRefreshScreen()
    //NavigationSafeScreen()
    //ShortcutScreen(intent = intent)
    //PreviewModeScreen()
    //MultiBackstackScreen()
    //ListDetailsWithNavigationScreen()
    //NavigationSuiteScreen()
    //ShakeScreen()
    //WaterBottleScreen()
    //SolidPrincipleScreen()
    //PdfGeneratorScreen()
    //AnimationTypesScreen()
    //LeastRecentlyUsedScreen()
    //MutualExclusionScreen()
    //BiometricAuthScreen()
    //SideEffectsScreen()
    //BallAnimationScreen()
    //CustomShapeScreen()
    //KeyboardFocusScreen()
    //OneTimeDataScreen()
    LocalSpicyScreen()


    //// Tasks ...
    //ArticlesNavigationScreen()
}

@Preview
@Composable
private fun MainPreview() {
    Main()
}