package bluevelvet.blueprint.app.presentation.activity

import bluevelvet.blueprint.app.R
import bluevelvet.blueprint.app.databinding.ActivityMainBinding
import bluevelvet.blueprint.app.navigation.MainFlowCoordinator
import bluevelvet.blueprint.core.base.ui.BaseActivity
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
