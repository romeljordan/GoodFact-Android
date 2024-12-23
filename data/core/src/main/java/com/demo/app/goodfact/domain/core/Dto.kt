package com.demo.app.goodfact.domain.core

interface Dto<R> {
    val domainModel: () -> R

    fun toDomainModel(): R {
        return domainModel()
    }
}
