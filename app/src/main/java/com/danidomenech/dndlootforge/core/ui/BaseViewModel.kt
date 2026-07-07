package com.danidomenech.dndlootforge.core.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(
    application: Application
) : AndroidViewModel(application) {
    protected val context: Context = application.applicationContext
}