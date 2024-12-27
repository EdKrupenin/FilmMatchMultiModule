package com.keo.source.base

sealed class DataType {
    data object GenreType : DataType()
    data object MovieType : DataType()
    data object SourceType : DataType()
}