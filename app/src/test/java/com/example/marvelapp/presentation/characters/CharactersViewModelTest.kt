package com.example.marvelapp.presentation.characters

import androidx.paging.PagingData
import br.com.core.domain.model.Character
import br.com.core.usecase.GetCharactersUseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    // ver sobre StandardTestDispatcher depois
    @OptIn(ExperimentalCoroutinesApi::class)
    val testDispatcher: TestDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private lateinit var charactersViewModel: CharactersViewModel

    private val pagingDataCharacters = PagingData.from(
        listOf(
            Character(
                "3-D Man",
                "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb8784.jpg"
            ),
            Character(
                "A-Bomb (HAS)",
                "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg"
            )
        )
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        charactersViewModel = CharactersViewModel(getCharactersUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should validate the paging data objects values when calling charactersPagingData`() =
        runTest {
            whenever(
                getCharactersUseCase.invoke(
                    any()
                )
            ).thenReturn(
                flowOf(pagingDataCharacters)
            )

            val result = charactersViewModel.charactersPagingData("")
            assertEquals(1, result.count())
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test(expected = RuntimeException::class)
    fun `should throw an exception when the calling to the use case returns an exception`() =
        runTest {
            whenever(getCharactersUseCase.invoke(any()))
                .thenThrow(RuntimeException())

            charactersViewModel.charactersPagingData("")
        }

}