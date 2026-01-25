package com.danidomenech.dndlootforge.ui.screens.lootlist

import android.app.Application
import com.danidomenech.dndlootforge.data.model.Item
import com.danidomenech.dndlootforge.domain.usecase.GetAllItemsUseCase
import com.danidomenech.dndlootforge.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class LootListViewModel @Inject constructor(
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
            .sortedBy { context.getString(it.nameResId).lowercase() }
    }
}