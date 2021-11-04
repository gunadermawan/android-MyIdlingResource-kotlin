package com.gunder.myidlingresource

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private val RESOURCE: String = "GLOBAL"
    private val espressoTestidlingResource = CountingIdlingResource(RESOURCE)
    fun increment() {
        espressoTestidlingResource.increment()
    }

    fun decrement() {
        espressoTestidlingResource.decrement()
    }

    fun getEspressoIdlingResource(): IdlingResource {
        return espressoTestidlingResource
    }
}