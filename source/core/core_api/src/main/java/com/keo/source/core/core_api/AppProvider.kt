package com.keo.source.core.core_api

import android.content.Context

interface AppProvider {
    fun provideContext(): Context
}