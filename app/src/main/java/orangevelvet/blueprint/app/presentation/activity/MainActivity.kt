package orangevelvet.blueprint.app.presentation.activity

import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orangevelvet.blueprint.core.base.view.BaseActivity
import orangevelvet.blueprint.app.R
import orangevelvet.blueprint.app.databinding.ActivityMainBinding
import orangevelvet.blueprint.app.navigation.MainFlowCoordinator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainFlowCoordinator>(
    ActivityMainBinding::inflate
) {
    @Inject
    lateinit var mainFlowCoordinator: MainFlowCoordinator

    override val graph: Int?
        get() = R.navigation.nav_graph_app
    override val navHostId: Int
        get() = R.id.nav_host_fragment_main
    override val coordinator: MainFlowCoordinator
        get() = mainFlowCoordinator

    private val viewModel: MainViewModel by viewModels()

    override fun initializeUIComponents() {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(this@MainActivity, viewModel.load().size.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
