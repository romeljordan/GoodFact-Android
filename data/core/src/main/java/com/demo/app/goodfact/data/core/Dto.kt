package com.demo.app.goodfact.data.core

interface Dto<R> {
    val domainModel: () -> R

    fun toDomainModel(): R {
        return domainModel()
    }
}
