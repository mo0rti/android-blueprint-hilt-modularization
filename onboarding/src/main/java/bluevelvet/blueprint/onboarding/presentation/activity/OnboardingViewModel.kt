package bluevelvet.blueprint.onboarding.presentation.activity

import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import bluevelvet.blueprint.core.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel
@Inject
constructor(
): BaseViewModel<
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect>() {
    override fun createInitialState(): EmptyViewState {
        return EmptyViewState()
    }

    override fun handleViewEvent(viewEvent: EmptyViewEvent) {
    }

}