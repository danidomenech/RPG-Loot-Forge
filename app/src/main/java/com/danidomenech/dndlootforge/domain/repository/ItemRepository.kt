package com.danidomenech.dndlootforge.domain.repository

import com.danidomenech.dndlootforge.domain.model.Item

interface ItemRepository {
    fun getAllItems(): List<Item>
}