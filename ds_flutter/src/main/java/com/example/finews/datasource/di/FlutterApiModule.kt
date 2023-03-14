package com.example.finews.datasource.di

import android.content.Context
import androidx.core.os.trace
import com.example.entity.common.TraceSection
import com.example.finews.datasource.api.FlutterNewsApi
import com.example.finews.datasource.api.FlutterNewsService
import com.example.finews.datasource.api.FlutterNewsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object FlutterApiModule {

    @Provides
    @Singleton
    fun provideFlutterEngine(
        @ApplicationContext appContext: Context
    ): FlutterEngine = trace(TraceSection.FLUTTER_INIT_ENGINE.traceName) {
        val flutterEngine = FlutterEngine(appContext).apply {
            dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        }

        FlutterEngineCache.getInstance().put("flutter", flutterEngine) //TODO Engine ID
        return flutterEngine
    }

    @Provides
    @Singleton
    fun provideFlutterNewsApi(
        flutterEngine: FlutterEngine
    )  = trace(TraceSection.FLUTTER_INIT_API.traceName) {
        FlutterNewsApi(flutterEngine.dartExecutor.binaryMessenger)
    }

    @Provides
    @Singleton
    fun provideFlutterNewsService(
        flutterNewsApi: FlutterNewsApi
    ): FlutterNewsService  = trace(TraceSection.FLUTTER_INIT_SERVICE.traceName) {
        FlutterNewsServiceImpl(flutterNewsApi)
    }
}