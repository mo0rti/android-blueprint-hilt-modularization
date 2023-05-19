package mortitech.blueprint.account.presentation.activity

import androidx.activity.viewModels
import mortitech.blueprint.account.R
import mortitech.blueprint.account.databinding.ActivityAccountBinding
import mortitech.blueprint.account.navigation.AccountFlowCoordinator
import mortitech.blueprint.core.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AccountActivity: BaseActivity<ActivityAccountBinding, AccountFlowCoordinator>(
    ActivityAccountBinding::inflate
) {
    @Inject
    lateinit var flowCoordinator: AccountFlowCoordinator

    override val graph: Int?
        get() = R.navigation.nav_graph_account
    override val navHostId: Int
        get() = R.id.nav_host_fragment_account
    override val coordinator: AccountFlowCoordinator
        get() = flowCoordinator

    private val viewModel: AccountViewModel by viewModels()

    override fun initializeUIComponents() {
    }
}

