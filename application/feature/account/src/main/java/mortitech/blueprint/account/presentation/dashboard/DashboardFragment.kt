package mortitech.blueprint.account.presentation.dashboard

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import mortitech.blueprint.account.R
import mortitech.blueprint.account.databinding.FragmentDashboardBinding
import mortitech.blueprint.account.presentation.dashboard.bonus.BonusFragmentDirections
import mortitech.blueprint.account.presentation.dashboard.cart.CartFragmentDirections
import mortitech.blueprint.account.presentation.dashboard.favorites.FavoritesFragmentDirections
import mortitech.blueprint.account.presentation.dashboard.home.HomeFragmentDirections
import mortitech.blueprint.account.presentation.dashboard.settings.SettingsFragmentDirections
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.core.ui.base.BaseFragment
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewEvent
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewAction
import mortitech.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment: BaseFragment<
        FragmentDashboardBinding,
        EmptyViewState,
        EmptyViewAction,
        EmptyViewEvent,
        DashboardViewModel>(
    FragmentDashboardBinding::inflate,
    ToolbarConfiguration(title = "")
) {
    override val viewModel: DashboardViewModel by viewModels()

    override fun initializeComponents() {
        val navHostFragment = childFragmentManager.findFragmentById(binding.navHostFragmentDashboard.id) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_action_home -> navController.navigate(HomeFragmentDirections.actionToHome())
                R.id.menu_action_favorites -> navController.navigate(FavoritesFragmentDirections.actionToFavorites())
                R.id.menu_action_bonus -> navController.navigate(BonusFragmentDirections.actionToBonus())
                R.id.menu_action_shopping_cart -> navController.navigate(CartFragmentDirections.actionToCart())
                R.id.menu_action_settings -> navController.navigate(SettingsFragmentDirections.actionToSettings())
            }
            true
        }
    }

    override fun onViewEventReceived(viewEvent: EmptyViewEvent) {
    }

    override fun onViewStateChanged(viewState: EmptyViewState) {
    }
}