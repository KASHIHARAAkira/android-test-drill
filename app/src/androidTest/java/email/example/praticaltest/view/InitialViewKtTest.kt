package email.example.praticaltest.view

import androidx.activity.viewModels
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import email.example.praticaltest.view_model.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InitialViewKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            MainView(mainViewModel = composeTestRule.activity.viewModels<MainViewModel>().value)
        }
    }

    @Test
    fun MyTest1() {
        val str1 = "Hello."
        val str2 = "I'm a student."
        composeTestRule.onNodeWithText("Str1").performTextInput(str1)   //テキスト入力、TextFieldのlabel = {Text("Str1")}が必要
        composeTestRule.onNodeWithText("Str2").performTextInput(str2)   //テキスト入力、TextFieldのlabel = {Text("Str2")}が必要
        composeTestRule.onNodeWithText("Send").performClick()
        composeTestRule.onNodeWithText("Success. Result is ${str1+str2}").assertIsDisplayed()
    }

    @Test
    fun MyTest2() {
        val str1 = "Hello."
        val str2 = ""
        composeTestRule.onNodeWithText("Str1").performTextInput(str1)   //テキスト入力、TextFieldのlabel = {Text("Str1")}が必要
        composeTestRule.onNodeWithText("Str2").performTextInput(str2)   //テキスト入力、TextFieldのlabel = {Text("Str2")}が必要
        composeTestRule.onNodeWithText("Send").performClick()
        composeTestRule.onNodeWithText("Success. Result is ${str1+str2}").assertIsDisplayed()
    }

    @Test
    fun MyTest3() {
        val str1 = ""
        val str2 = "I'm a student."
        composeTestRule.onNodeWithText("Str1").performTextInput(str1)   //テキスト入力、TextFieldのlabel = {Text("Str1")}が必要
        composeTestRule.onNodeWithText("Str2").performTextInput(str2)   //テキスト入力、TextFieldのlabel = {Text("Str2")}が必要
        composeTestRule.onNodeWithText("Send").performClick()
        composeTestRule.onNodeWithText("Success. Result is ${str1+str2}").assertIsDisplayed()
    }

    @Test
    fun MyTest4() {
        val str1 = ""
        val str2 = ""
        composeTestRule.onNodeWithText("Str1").performTextInput(str1)   //テキスト入力、TextFieldのlabel = {Text("Str1")}が必要
        composeTestRule.onNodeWithText("Str2").performTextInput(str2)   //テキスト入力、TextFieldのlabel = {Text("Str2")}が必要
        composeTestRule.onNodeWithText("Send").performClick()
        composeTestRule.onNodeWithText("Success. Result is 文字列が入力されていません").assertIsDisplayed()
    }
}