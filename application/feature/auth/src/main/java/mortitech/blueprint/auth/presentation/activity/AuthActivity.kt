package mortitech.blueprint.auth.presentation.activity

import androidx.activity.viewModels
import mortitech.blueprint.auth.R
import mortitech.blueprint.auth.databinding.ActivityAuthBinding
import mortitech.blueprint.auth.navigation.AuthFlowCoordinator
import mortitech.blueprint.core.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity: BaseActivity<ActivityAuthBinding, AuthFlowCoordinator>(
    ActivityAuthBinding::inflate
) {
    @Inject
    lateinit var flowCoordinator: AuthFlowCoordinator

    override val graph: Int
        get() = R.navigation.nav_graph_auth
    override val navHostId: Int
        get() = R.id.nav_host_fragment_auth
    override val coordinator: AuthFlowCoordinator
        get() = flowCoordinator

    private val viewModel: AuthViewModel by viewModels()

    override fun initializeUIComponents() {
    }
}
