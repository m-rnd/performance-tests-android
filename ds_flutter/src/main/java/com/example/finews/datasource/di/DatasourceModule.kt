package com.example.finews.datasource.di

import android.content.Context
import com.example.entity.datasource.NewsDataSource
import com.example.finews.datasource.api.FlutterNewsApi
import com.example.finews.datasource.api.FlutterNewsDataSource
import com.example.finews.datasource.api.FlutterNewsService
import com.example.finews.datasource.api.FlutterNewsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatasourceModule {

    @Provides
    @Singleton
    fun provideNewsDataSource(
        flutterNewsService: FlutterNewsService
    ): NewsDataSource = FlutterNewsDataSource(flutterNewsService)

}

fun getFlutterNews(appContext: Context): NewsDataSource {
    val flutterEngine = FlutterEngine(appContext).apply {
        dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
    }

    FlutterEngineCache.getInstance().put("flutter", flutterEngine) //TODO Engine ID
    return FlutterNewsDataSource(FlutterNewsServiceImpl(
        FlutterNewsApi(flutterEngine.dartExecutor.binaryMessenger)
    ))
}