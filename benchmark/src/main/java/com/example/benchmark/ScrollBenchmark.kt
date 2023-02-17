package com.example.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScrollBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun full() = scroll(CompilationMode.Full())

    private fun scroll(compilationMode: CompilationMode) =
        benchmarkRule.measureRepeated(
            packageName = PackageName,
            metrics = listOf(
                StartupTimingMetric(), FrameTimingMetric()
            ),
            compilationMode = compilationMode,
            startupMode = StartupMode.COLD,
            iterations = 5
        ) {
            startActivityAndWait()
            device.wait(Until.hasObject(By.scrollable(true)), 5_000)

            val scrollableObject = device.findObject(By.scrollable(true))
            if (scrollableObject == null) {
                Assert.fail("No scrollable view found in hierarchy")
            }
            scrollableObject.setGestureMargin(device.displayWidth / 10)
            scrollableObject?.apply {
                repeat(2) {
                    fling(Direction.DOWN)
                }
                repeat(2) {
                    fling(Direction.UP)
                }
            }
        }
}