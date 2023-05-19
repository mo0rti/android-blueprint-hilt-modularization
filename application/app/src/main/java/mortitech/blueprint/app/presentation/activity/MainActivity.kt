package mortitech.blueprint.app.presentation.activity

import mortitech.blueprint.app.R
import mortitech.blueprint.app.databinding.ActivityMainBinding
import mortitech.blueprint.app.navigation.MainFlowCoordinator
import mortitech.blueprint.core.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainFlowCoordinator>(
    ActivityMainBinding::inflate
) {
    @Inject
    lateinit var flowCoordinator: MainFlowCoordinator

    override val graph: Int
        get() = R.navigation.nav_graph_app
    override val navHostId: Int
        get() = R.id.nav_host_fragment_main
    override val coordinator: MainFlowCoordinator
        get() = flowCoordinator

    override fun initializeUIComponents() {}
}
