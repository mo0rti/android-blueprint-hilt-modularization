package mortitech.blueprint.core.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewbinding.ViewBinding
import mortitech.blueprint.core.ui.ToolbarConfiguration
import mortitech.blueprint.navigation.coordinator.Coordinator
import mortitech.blueprint.navigation.coordinator.CoordinatorHost
import mortitech.blueprint.navigation.navigator.StartDestination
import mortitech.blueprint.style.R as style

typealias ActivityInflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB: ViewBinding, C: Coordinator>(
    private val inflate: ActivityInflate<VB>
) : AppCompatActivity(), CoordinatorHost<C> {

    abstract fun initializeUIComponents()

    private lateinit var _binding: VB

    @get:NavigationRes
    abstract val graph: Int?

    @get:IdRes
    abstract val navHostId: Int

    private lateinit var _appBarConfiguration: AppBarConfiguration
    private var _toolbar: Toolbar? = null
    private var _tvToolbarTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = inflate.invoke(layoutInflater)
        setContentView(_binding.root)

        initializeCoordinator()
        initializeToolbar()
        initializeUIComponents()
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.clear()
    }

    private fun initializeCoordinator() {
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
    }

    private fun initializeToolbar() {
        findViewById<Toolbar>(style.id.toolbar)?.apply {
            _toolbar = this
            _tvToolbarTitle = this.findViewById(style.id.tvToolbarTitle)
            setSupportActionBar(this)
            coordinator.navController?.let {
                setupActionBarWithNavController(it)
            }
        }
    }

    fun updateToolbar(configuration: ToolbarConfiguration) {
        if (configuration.isVisible) {
            supportActionBar?.show()
            _toolbar?.let { _ ->
                if (configuration.title.isNotEmpty()) {
                    _tvToolbarTitle?.apply { text = configuration.title }
                }
            }
        } else {
            supportActionBar?.hide()
        }
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

fun Activity.showToast(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.showDialog(
    message:String,
    callback: (() -> Unit)? = null
) {
    with(AlertDialog.Builder(this)) {
        setTitle("Info")
        setMessage(message)
        setPositiveButton("Ok") { dialog, _ ->
            callback?.invoke()
            dialog.dismiss()
        }
        create().show()
    }
}
