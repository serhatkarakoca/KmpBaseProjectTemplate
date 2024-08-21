package com.karakoca.baseproject.presentation.favorite

import com.karakoca.baseproject.base.BaseViewModel
import com.karakoca.baseproject.base.Event
import com.karakoca.baseproject.base.State

class FavoriteViewModel : BaseViewModel<FavoriteState, FavoriteEvent>() {
    override fun setInitialState(): FavoriteState {
        return FavoriteState()
    }

    override fun handleEvent(event: FavoriteEvent) {

    }
}

data class FavoriteState(val isLoading: Boolean = false) : State

sealed interface FavoriteEvent : Event {

}