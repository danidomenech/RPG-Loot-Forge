package com.danidomenech.dndlootforge.ui.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(
    application: Application
) : AndroidViewModel(application) {
    protected val context: Context = application.applicationContext
}