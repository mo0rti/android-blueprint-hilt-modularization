package orangevelvet.androidblueprint.hilt.presentation.ui.main.activity

import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orangevelvet.androidblueprint.core.base.view.BaseActivity
import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.databinding.ActivityMainBinding
import orangevelvet.androidblueprint.hilt.presentation.navigation.coordinators.MainFlowCoordinator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainFlowCoordinator>(
    ActivityMainBinding::inflate
) {

    @Inject
    lateinit var mainFlowCoordinator: MainFlowCoordinator

    override val graph: Int?
        get() = R.navigation.nav_graph_main
    override val navHostId: Int
        get() = R.id.nav_host_fragment_main
    override val coordinator: MainFlowCoordinator
        get() = mainFlowCoordinator

    private val viewModel: MainViewModel by viewModels()

    override fun initUIComponents() {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(this@MainActivity, viewModel.load().size.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
