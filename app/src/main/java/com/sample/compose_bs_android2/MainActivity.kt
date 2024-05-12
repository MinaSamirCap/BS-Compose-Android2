package com.sample.compose_bs_android2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sample.compose_bs_android2.mine.pullToRefresh.PullToRefreshScreen
import com.sample.compose_bs_android2.mine.sharedElement.SharedElementScreen
import com.sample.compose_bs_android2.template.TemplateScreen
import com.sample.compose_bs_android2.ui.theme.ComposeBSAndroid2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBSAndroid2Theme {
                Main()
            }
        }
    }
}


@Composable
fun Main(modifier: Modifier = Modifier) {
    //TemplateScreen()
    //SharedElementScreen()
    PullToRefreshScreen()
}

@Preview
@Composable
private fun MainPreview() {
    Main()
}