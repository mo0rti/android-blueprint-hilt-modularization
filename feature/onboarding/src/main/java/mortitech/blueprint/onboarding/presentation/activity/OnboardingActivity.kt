package mortitech.blueprint.onboarding.presentation.activity

import androidx.activity.viewModels
import mortitech.blueprint.core.ui.base.BaseActivity
import mortitech.blueprint.onboarding.R
import mortitech.blueprint.onboarding.databinding.ActivityOnboardingBinding
import mortitech.blueprint.onboarding.navigation.OnboardingFlowCoordinator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingActivity : BaseActivity<ActivityOnboardingBinding, OnboardingFlowCoordinator>(
    ActivityOnboardingBinding::inflate
) {
    @Inject
    lateinit var flowCoordinator: OnboardingFlowCoordinator

    override val graph: Int?
        get() = R.navigation.nav_graph_onboarding
    override val navHostId: Int
        get() = R.id.nav_host_fragment_onboarding
    override val coordinator: OnboardingFlowCoordinator
        get() = flowCoordinator

    private val viewModel: OnboardingViewModel by viewModels()

    override fun initializeUIComponents() {
    }
}
