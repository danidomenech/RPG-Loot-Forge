package com.danidomenech.dndlootforge.feature.narrativelootlist

import androidx.lifecycle.ViewModel
import com.danidomenech.dndlootforge.domain.usecase.GetNarrativeLootItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class NarrativeLootListViewModel @Inject constructor(
    getNarrativeLootItemsUseCase: GetNarrativeLootItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        NarrativeLootListUiState(
            items = getNarrativeLootItemsUseCase()
        )
    )

    val uiState: StateFlow<NarrativeLootListUiState> = _uiState.asStateFlow()
}