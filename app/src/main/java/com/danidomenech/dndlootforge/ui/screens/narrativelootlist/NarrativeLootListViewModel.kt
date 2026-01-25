package com.danidomenech.dndlootforge.ui.screens.narrativelootlist

import android.app.Application
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import com.danidomenech.dndlootforge.ui.base.BaseViewModel
import com.danidomenech.dndlootforge.utils.ItemUtils.rarityOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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
                    .thenBy { rarityOrder.indexOf(it.rarity) }
            )
    }
}