package bluevelvet.blueprint.auth.presentation.activity

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import bluevelvet.blueprint.auth.R
import bluevelvet.blueprint.auth.databinding.ActivityAuthBinding
import bluevelvet.blueprint.auth.navigation.AuthFlowCoordinator
import bluevelvet.blueprint.core.base.view.BaseActivity
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity: BaseActivity<ActivityAuthBinding, AuthFlowCoordinator>(
    ActivityAuthBinding::inflate
) {
    @Inject
    lateinit var authFlowCoordinator: AuthFlowCoordinator

    override val graph: Int?
        get() = R.navigation.nav_graph_auth
    override val navHostId: Int
        get() = R.id.nav_host_fragment_auth
    override val coordinator: AuthFlowCoordinator
        get() = authFlowCoordinator

    private val viewModel: AuthViewModel by viewModels()

    override fun initializeUIComponents() {
    }
}
