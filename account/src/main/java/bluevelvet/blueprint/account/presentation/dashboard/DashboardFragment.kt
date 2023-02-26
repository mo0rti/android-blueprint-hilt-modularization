package bluevelvet.blueprint.account.presentation.dashboard

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import bluevelvet.blueprint.account.R
import bluevelvet.blueprint.account.databinding.FragmentDashboardBinding
import bluevelvet.blueprint.account.presentation.dashboard.bonus.BonusFragmentDirections
import bluevelvet.blueprint.account.presentation.dashboard.cart.CartFragmentDirections
import bluevelvet.blueprint.account.presentation.dashboard.favorites.FavoritesFragmentDirections
import bluevelvet.blueprint.account.presentation.dashboard.home.HomeFragmentDirections
import bluevelvet.blueprint.account.presentation.dashboard.settings.SettingsFragmentDirections
import bluevelvet.blueprint.core.ui.ToolbarConfiguration
import bluevelvet.blueprint.core.ui.base.BaseFragment
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEffect
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewEvent
import bluevelvet.blueprint.core.ui.state.view.empty.EmptyViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment: BaseFragment<
        FragmentDashboardBinding,
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewEffect,
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

    override fun onViewEffectReceived(viewEffect: EmptyViewEffect) {
    }

    override fun onViewStateChange(viewState: EmptyViewState) {
    }
}