package orangevelvet.blueprint.auth.presentation.login

import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.blueprint.core.base.state.view.empty.EmptyViewAction
import orangevelvet.blueprint.core.base.state.view.empty.EmptyViewEvent
import orangevelvet.blueprint.core.base.state.view.empty.EmptyViewState
import orangevelvet.blueprint.core.base.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(
) : BaseViewModel<
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewAction
        >() {

    override fun postAction(action: EmptyViewAction) {
    }
}