package com.example.entity.common

const val TracePrefix = "FINewsTrace_"

enum class TraceSection(val traceName: String) {
    FLUTTER_INIT_ENGINE("${TracePrefix}FlutterApiModule.provideFlutterEngine"),
    FLUTTER_INIT_API("${TracePrefix}FlutterApiModule.provideFlutterNewsApi"),
    FLUTTER_INIT_SERVICE("${TracePrefix}FlutterApiModule.provideFlutterNewsService"),

    RETROFIT_INIT_GSON("${TracePrefix}RetrofitApiModule.provideGson"),
    RETROFIT_INIT_LOGGING("${TracePrefix}RetrofitApiModule.provideLoggingInterceptor"),
    RETROFIT_INIT_HTTP_CLIENT("${TracePrefix}RetrofitApiModule.provideHttpClient"),
    RETROFIT_INIT_RETRO_BUILDER("${TracePrefix}RetrofitApiModule.provideRetrofit"),
    RETROFIT_INIT_SERVICE("${TracePrefix}RetrofitApiModule.provideNewsService"),

    MAIN_VM_ON_CLICK("${TracePrefix}MainViewModel.onDownloadClick"),

    REPOSITORY_GET_NEWS("${TracePrefix}NewsRepositoryImpl.getNews"),
    NATIVE_DS_GET_NEWS("${TracePrefix}NativeNewsDataSource.getNews"),
    NATIVE_API_CALL("${TracePrefix}callApi"),
}