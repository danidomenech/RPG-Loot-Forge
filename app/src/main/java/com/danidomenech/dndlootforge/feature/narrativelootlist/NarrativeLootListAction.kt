package com.danidomenech.dndlootforge.feature.narrativelootlist

import com.danidomenech.dndlootforge.domain.model.Item

sealed interface NarrativeLootListAction {
    data class ItemClick(val item: Item) : NarrativeLootListAction
}