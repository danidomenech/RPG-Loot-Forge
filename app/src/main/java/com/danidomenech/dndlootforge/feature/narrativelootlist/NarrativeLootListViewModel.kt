package com.danidomenech.dndlootforge.feature.narrativelootlist

import android.app.Application
import com.danidomenech.dndlootforge.domain.model.Item
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import com.danidomenech.dndlootforge.core.ui.BaseViewModel
import com.danidomenech.dndlootforge.domain.model.sortOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NarrativeLootListViewModel @Inject constructor(
    application: Application,
    private val getAllItemsUseCase: GetAllItemsUseCase
) : BaseViewModel(application) {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    init {
        loadItems()
    }

    private fun loadItems() {
        _items.value = getAllItemsUseCase()
            .filter { it.narrativeLootExclusive }
            .sortedWith(
                compareBy<Item> { it.powerLevel }
                    .thenBy { it.rarity.sortOrder }
            )
    }
}