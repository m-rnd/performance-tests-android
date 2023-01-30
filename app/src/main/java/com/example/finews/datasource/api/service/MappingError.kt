package com.example.finews.datasource.api.service

import timber.log.Timber
import kotlin.reflect.KProperty0

inline fun <reified T> mappingError(field: KProperty0<String?>): T? {
    Timber.e("mapping error on field ${field.name} of class ${T::class.simpleName}")
    return null
}
