package com.danidomenech.dndlootforge.data.repository

import com.danidomenech.dndlootforge.data.model.Item

interface ItemRepository {
    fun getAllItems(): List<Item>
}