package com.keo.filmmatch

import android.app.Application
import android.content.Context
import com.keo.source.core.core_api.AppProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationContextComponent : AppProvider {

    companion object{
        private var appComponent: AppProvider? = null

        fun create(application: Application): AppProvider {
            return appComponent ?: DaggerApplicationContextComponent
                .builder()
                .application(application.applicationContext)
                .build().also {
                    appComponent = it
                }
        }
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context) : Builder

        fun build(): ApplicationContextComponent
    }
}