package com.danidomenech.dndlootforge.data.local.source

import com.danidomenech.dndlootforge.data.local.model.LocalItem

interface ItemLocalDataSource {
    fun getItems(): List<LocalItem>
}