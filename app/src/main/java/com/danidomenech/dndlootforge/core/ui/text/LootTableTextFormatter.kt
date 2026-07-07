package com.danidomenech.dndlootforge.core.ui.text

fun IntRange?.toPlayerLevelText(): String {
    return when {
        this == null -> "-"
        first == last -> first.toString()
        else -> "$first-$last"
    }
}