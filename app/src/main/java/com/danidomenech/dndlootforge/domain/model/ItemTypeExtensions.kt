package com.danidomenech.dndlootforge.domain.model

val ItemType.isGear: Boolean
    get() = category.isGear