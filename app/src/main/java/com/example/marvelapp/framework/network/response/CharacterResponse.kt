package com.example.marvelapp.framework.network.response

import br.com.core.domain.model.Character

data class CharacterResponse(
    val id: String,
    val name: String,
    val description: String,
    val thumbnailResponse: ThumbnailResponse
)

fun CharacterResponse.toCharacterModel(): Character {
    return Character(
        name = this.name,
        imageUrl =  "${this.thumbnailResponse.path}.${this.thumbnailResponse.extension}"
    )
}
