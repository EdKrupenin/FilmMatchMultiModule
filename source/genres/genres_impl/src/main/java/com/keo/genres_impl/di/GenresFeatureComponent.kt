package com.keo.genres_impl.di

import com.keo.genres_impl.GenresFeatureImpl
import com.keo.genres_impl.GenresFeatureVM
import com.keo.source.base.di.BaseComponent
import dagger.Component

@Component(
    dependencies = [BaseComponent::class],
    modules = [GenresFeatureModule::class]
)
interface GenresFeatureComponent {
    companion object {
        fun create(baseComponent: BaseComponent): GenresFeatureComponent {
            return DaggerGenresFeatureComponent.builder()
                .baseComponent(baseComponent)
                .build()
        }
    }
    fun inject(feature: GenresFeatureImpl)

    fun viewModelFactory(): GenresFeatureVM.Factory
}