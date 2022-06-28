package orangevelvet.androidblueprint.hilt.presentation.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orangevelvet.androidblueprint.hilt.R
import orangevelvet.androidblueprint.hilt.domain.contract.CurrencyNetworkService
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var currencyNetworkService: CurrencyNetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(this@MainActivity, currencyNetworkService.getCurrencies().size.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
