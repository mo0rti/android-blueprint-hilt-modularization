package bluevelvet.blueprint.account.presentation.activity

import androidx.activity.viewModels
import bluevelvet.blueprint.account.R
import bluevelvet.blueprint.account.databinding.ActivityAccountBinding
import bluevelvet.blueprint.account.navigation.AccountFlowCoordinator
import bluevelvet.blueprint.core.base.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AccountActivity: BaseActivity<ActivityAccountBinding, AccountFlowCoordinator>(
    ActivityAccountBinding::inflate
) {
    @Inject
    lateinit var authFlowCoordinator: AccountFlowCoordinator

    override val graph: Int?
        get() = R.navigation.nav_graph_account
    override val navHostId: Int
        get() = R.id.nav_host_fragment_account
    override val coordinator: AccountFlowCoordinator
        get() = authFlowCoordinator

    private val viewModel: AccountViewModel by viewModels()

    override fun initializeUIComponents() {
    }
}

