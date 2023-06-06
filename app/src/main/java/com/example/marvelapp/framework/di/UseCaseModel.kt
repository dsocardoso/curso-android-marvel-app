package com.example.marvelapp.framework.di

import br.com.core.usecase.GetCharactersUseCase
import br.com.core.usecase.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModel {

    @Binds
    fun bindCharactersUseCase(useCase: GetCharactersUseCaseImpl): GetCharactersUseCase
}
