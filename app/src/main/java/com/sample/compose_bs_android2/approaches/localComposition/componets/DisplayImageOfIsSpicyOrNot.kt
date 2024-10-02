package com.sample.compose_bs_android2.approaches.localComposition.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.R
import com.sample.compose_bs_android2.approaches.localComposition.LocalSpicy

@Composable
fun DisplayImageOfIsSpicyOrNot(modifier: Modifier = Modifier) {

    val resource = if (LocalSpicy.current) R.drawable.spicy else R.drawable.regular
    Image(
        painter = painterResource(id = resource),
        contentDescription = null,
        modifier = modifier.size(200.dp)
    )

}

@Preview
@Composable
private fun DisplayImageOfIsSpicyOrNotPreview() {
    DisplayImageOfIsSpicyOrNot()
}