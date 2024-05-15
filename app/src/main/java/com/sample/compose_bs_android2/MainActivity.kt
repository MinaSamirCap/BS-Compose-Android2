package com.sample.compose_bs_android2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sample.compose_bs_android2.mine.navigation.NavigationSafeScreen
import com.sample.compose_bs_android2.mine.pullToRefresh.PullToRefreshScreen
import com.sample.compose_bs_android2.mine.sharedElement.SharedElementScreen
import com.sample.compose_bs_android2.mine.shortcuts.ShortcutScreen
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
    ShortcutScreen(intent = intent)
}

@Preview
@Composable
private fun MainPreview() {
    Main()
}