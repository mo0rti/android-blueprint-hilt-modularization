package orangevelvet.blueprint.auth.presentation.activity

import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orangevelvet.blueprint.auth.R
import orangevelvet.blueprint.auth.databinding.ActivityAuthBinding
import orangevelvet.blueprint.auth.navigation.AuthFlowCoordinator
import orangevelvet.blueprint.core.base.view.BaseActivity
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
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(this@AuthActivity, viewModel.load().size.toString(), Toast.LENGTH_LONG).show()
        }
    }
}