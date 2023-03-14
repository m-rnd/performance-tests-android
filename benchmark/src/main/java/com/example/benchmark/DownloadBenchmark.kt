package com.example.benchmark

import android.os.Debug
import androidx.benchmark.macro.*
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DownloadBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @OptIn(ExperimentalMetricApi::class)
    @Test
    fun download() = benchmarkRule.measureRepeated(
        packageName = PackageName,
        metrics = listOf(FrameTimingMetric(), TraceSectionMetric("MainViewModel.onDownloadClick")),
        iterations = 1,
        startupMode = StartupMode.COLD,
        setupBlock = setupDownload()
    ) {
        val downloadButton = By.text("download")
        device.wait(Until.hasObject(downloadButton), 5_000)
        val clickableObject = device.findObject(downloadButton)
        if (clickableObject == null) {
            Assert.fail("No clickable view found in hierarchy")
        }
        clickableObject.click()
        device.wait(Until.gone(By.text("downloading...")), 30_000)
    }

    private fun setupDownload(): MacrobenchmarkScope.() -> Unit = {
        pressHome()
        startActivityAndWait()
    }
}