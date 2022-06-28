package orangevelvet.androidblueprint.hilt.presentation.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import orangevelvet.androidblueprint.hilt.R

@AndroidEntryPoint
class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
    }
}
