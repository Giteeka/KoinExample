package com.app.koinexample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.app.koinexample.data.AppDataManager
import com.app.koinexample.data.AppPreferenceHelper
import com.app.koinexample.data.DataManager
import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import com.app.koinexample.ui.list.ListViewModel
import com.app.koinexample.ui.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.mock.declareMock

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest : KoinTest {

//    val auth: Auth by inject()

    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @get:Rule
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)


    @Before
    fun setup() {
        loadKoinModules(module {
            factory { DispatcherProvider() }
            single { RandomUserDatabase.getInMemoryDatabase(activityRule.getActivity().applicationContext) }
            single {
                AppPreferenceHelper.getInstance(
                    activityRule.getActivity().applicationContext,
                    "Pref"
                )
            }
            single {
                RandomUserAPI.defaultInstance(
                    (activityRule.getActivity().applicationContext as? KoinApp)?.baseUrl ?: ""
                )
            }
            single { AppDataManager(get(), get(), get()) } bind DataManager::class
        })
        declareMock<ListViewModel>()
        declareMock<RandomUserDatabase>()
        declareMock<AppPreferenceHelper>()
        declareMock<RandomUserAPI>()
        declareMock<AppDataManager>()
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun blankFields() {
        activityRule.launchActivity(null)
//        onView(ViewMatchers.withId(R.id.login)).perform(click())
//
//        onView(allOf<View>(withId(com.google.android.material.R.id.snackbar_text), withText("Please fill both fields")))
//                .check(matches(isDisplayed()))
    }

    @Test
    fun invalidCredentials() {
//        val captor = ArgumentCaptor.forClass(Auth.AuthCompletedListener::class.java)
//        doAnswer {
//            (it.arguments[0] as Auth.AuthCompletedListener).onCompleted(false, "Invalid username or password")
//        }.`when`(auth).authenticate("", "", captor.capture())
//        activityRule.launchActivity(null)
////        `when`(activityRule.activity.viewModel.validateCredentials(null)).then { doNothing() }
//        onView(withId(R.id.username)).perform(typeText("dsaf"), closeSoftKeyboard())
//        onView(withId(R.id.password)).perform(typeText("dssdfsaf"), closeSoftKeyboard())
//        onView(withId(R.id.login)).perform(click())
//
//        onView(withId(R.id.progressBar))
//                .check(matches(isDisplayed()))
//
//        onView(allOf<View>(withId(com.google.android.material.R.id.snackbar_text), withText("Invalid username or password")))
//                .check(matches(isDisplayed()))
    }

}
