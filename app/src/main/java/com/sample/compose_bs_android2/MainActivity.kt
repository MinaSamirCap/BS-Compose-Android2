package com.sample.compose_bs_android2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sample.compose_bs_android2.mine.listDetails.ListDetailsWithNavigationScreen
import com.sample.compose_bs_android2.mine.multiBackstack.MultiBackstackScreen
import com.sample.compose_bs_android2.mine.navigation.NavigationSafeScreen
import com.sample.compose_bs_android2.mine.navigationSuite.NavigationSuiteScreen
import com.sample.compose_bs_android2.mine.pdf.PdfGeneratorScreen
import com.sample.compose_bs_android2.mine.previewMode.PreviewModeScreen
import com.sample.compose_bs_android2.mine.pullToRefresh.PullToRefreshScreen
import com.sample.compose_bs_android2.mine.shake.ShakeScreen
import com.sample.compose_bs_android2.mine.sharedElement.SharedElementScreen
import com.sample.compose_bs_android2.mine.shortcuts.ShortcutScreen
import com.sample.compose_bs_android2.mine.solid.SolidPrincipleScreen
import com.sample.compose_bs_android2.mine.waterBottle.WaterBottleScreen
import com.sample.compose_bs_android2.tasks.task1Articles.ui.navigation.ArticlesNavigationScreen
import com.sample.compose_bs_android2.template.TemplateScreen
import com.sample.compose_bs_android2.ui.theme.ComposeBSAndroid2Theme

class MainActivity : ComponentActivity() {

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


    //// Tasks ...
    ArticlesNavigationScreen()
}

@Preview
@Composable
private fun MainPreview() {
    Main()
}