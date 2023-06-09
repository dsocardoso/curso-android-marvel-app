package com.example.testing.model

import br.com.core.domain.model.Character
import org.junit.experimental.theories.Theories

class CharacterFactory {
    fun create(hero: Hero) = when(hero) {
        Hero.ThreeDMan -> Character(
            "3-D Man",
            "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb8784.jpg"
        )
        Hero.ABom -> Character(
            "A-Bomb (HAS)",
            "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg"
        )
    }

    sealed class Hero {
        object ThreeDMan: Hero()
        object ABom: Hero()
    }
}
