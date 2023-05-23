package br.com.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.core.data.repository.CharactersRepository
import br.com.core.domain.model.Character
import br.com.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersUseCase.GetCharacterParams, Character>() {

    override fun createFlowObservable(params: GetCharacterParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig) {
            charactersRepository.getCharacteres(params.query)
        }.flow
    }

    data class GetCharacterParams(val query: String, val pagingConfig: PagingConfig)
}
