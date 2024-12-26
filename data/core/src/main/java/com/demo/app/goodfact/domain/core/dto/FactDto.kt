package com.demo.app.goodfact.domain.core.dto

import com.demo.app.goodfact.domain.core.Dto
import com.demo.app.goodfact.domain.core.model.Fact

data class FactDto(
    val id: String,
    val text: String,
    val source: String
): Dto<Fact> {
    override val domainModel: () -> Fact
        get() = {
            Fact(
                id = id,
                content = text.replace("`", "'"),
                source = source
            )
        }
}
