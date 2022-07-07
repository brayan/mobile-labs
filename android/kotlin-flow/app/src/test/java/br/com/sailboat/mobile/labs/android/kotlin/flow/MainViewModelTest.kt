package br.com.sailboat.mobile.labs.android.kotlin.flow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `countDownFlow, properly counts down from 10 to 0`() = runBlocking {
        withContext(coroutinesTestRule.dispatcherProvider.main()) {
            viewModel.countDownFlow.test {
                for (i in 10 downTo 0) {
                    coroutinesTestRule.scope.advanceTimeBy(10000L)
                    val emission = awaitItem() // wait for the next emission
                    assertThat(emission).isEqualTo(i)
                }
                cancelAndConsumeRemainingEvents()
            }
        }
    }

    @Test
    fun `squareNumber, number properly squared`() = runBlocking {
        val job = launch {
            viewModel.sharedFlow.test {
                val emission = awaitItem()
                assertThat(emission).isEqualTo(9)
                cancelAndConsumeRemainingEvents()
            }
        }

        viewModel.squareNumber(3)
        job.join()
        job.cancel()
    }
}
