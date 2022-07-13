package orangevelvet.blueprint.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewbinding.ViewBinding
import orangevelvet.blueprint.navigation.coordinator.Coordinator
import orangevelvet.blueprint.navigation.coordinator.CoordinatorHost
import orangevelvet.blueprint.navigation.navigator.StartDestination

typealias ActivityInflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB: ViewBinding, C: Coordinator>(
    private val inflate: ActivityInflate<VB>
): AppCompatActivity(), CoordinatorHost<C> {

    abstract fun initUIComponents()

    private lateinit var _binding: VB

    @get:NavigationRes
    abstract val graph: Int?

    @get:IdRes
    abstract val navHostId: Int

    private lateinit var _appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = inflate.invoke(layoutInflater)
        setContentView(_binding.root)

        val host = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
        coordinator.navHostFragment = host
        coordinator.activity = this
        coordinator.navController = host.navController

        graph?.let { grp ->
            setupNavigationGraph(graphId = grp, host = host, startDestination = coordinator.onStart())
            coordinator.navController?.let {
                _appBarConfiguration = AppBarConfiguration(it.graph)
                this.onBackPressedDispatcher.addCallback(this) {
                    it.navigateUp(_appBarConfiguration)
                }
            }
        }

        initUIComponents()
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.clear()
    }

    fun configureToolbar(configuration: ToolbarConfiguration) {
    }

    private fun setupNavigationGraph(
        @NavigationRes graphId: Int,
        host: NavHostFragment,
        startDestination: StartDestination,
    ) {
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(graphId)
        graph.setStartDestination(startDestination.destination)
        host.navController.setGraph(graph, startDestination.args)
    }
}