package com.sample.compose_bs_android2.mine.tasks.task1Articles

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isSelectable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sample.compose_bs_android2.R
import com.sample.compose_bs_android2.tasks.task1Articles.ui.details.ArticleDetailsScreen
import com.sample.compose_bs_android2.tasks.task1Articles.ui.navigation.ArticlesRoute
import org.junit.Rule
import org.junit.Test

class ArticlesDetailsScreenTest {


//    @get:Rule
//    val composeTestRule = createComposeRule()

    @get:Rule
    val composeTestAndroidRule = createAndroidComposeRule<ComponentActivity>()

    private val articleModel = ArticlesRoute.ArticleDetails(
        title = "Article Title",
        by = "Author",
        publishedDate = "20-02-2022",
        articleUrl = "",
        imageUrl = ""
    )

    @Test
    fun titleAndAuthorAreExistsTest() {
        composeTestAndroidRule.setContent {
            ArticleDetailsScreen(item = articleModel)
        }

        composeTestAndroidRule.onNodeWithText(articleModel.title!!).assertExists()
        composeTestAndroidRule.onNode(hasText(articleModel.by!!)).assertIsDisplayed()
    }

    @Test
    fun openBrowserIsClickableTest() {

        composeTestAndroidRule.setContent {
            ArticleDetailsScreen(item = articleModel)
        }

        val openBrowserText =
            composeTestAndroidRule.activity.resources.getString(R.string.open_browser)

        composeTestAndroidRule.onNodeWithText(openBrowserText).assertExists()
        composeTestAndroidRule.onNode(
            hasText(openBrowserText)
                    and hasParent(isSelectable())
        )
    }
}