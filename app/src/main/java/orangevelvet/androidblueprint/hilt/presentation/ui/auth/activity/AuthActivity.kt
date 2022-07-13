package orangevelvet.androidblueprint.hilt.presentation.ui.auth.activity

import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orangevelvet.androidblueprint.core.base.view.BaseActivity
import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.databinding.ActivityAuthBinding
import orangevelvet.androidblueprint.hilt.presentation.navigation.coordinators.AuthFlowCoordinator
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding, AuthFlowCoordinator>(
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

    override fun initUIComponents() {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(this@AuthActivity, viewModel.load().size.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
