package br.com.core.usecase

import androidx.paging.PagingConfig
import br.com.core.data.repository.CharactersRepository
import com.example.testing.MainCoroutineRule
import com.example.testing.model.CharacterFactory
import com.example.testing.pagingsource.PagingSourceFactory
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseImplTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    @Mock
    lateinit var repository: CharactersRepository

    private val hero = CharacterFactory().create(CharacterFactory.Hero.ThreeDMan)

    private val fakingPageSource = PagingSourceFactory().create(listOf(
        hero
    ))

    @Before
    fun setUp() {
        getCharactersUseCase = GetCharactersUseCaseImpl(repository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should validation flow paging data creation when invoke from use case is called`() {
        runTest {

            whenever(repository.getCharacteres(""))
                .thenReturn(fakingPageSource)

            val result = getCharactersUseCase
                .invoke(GetCharactersUseCase.GetCharacterParams("", PagingConfig(20)))

            assertNotNull(result.first())
        }
    }

}
