package mortitech.blueprint.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoggingInterceptorOkHttpClient

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher
