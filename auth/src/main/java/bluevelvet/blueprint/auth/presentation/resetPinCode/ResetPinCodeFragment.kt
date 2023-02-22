package bluevelvet.blueprint.auth.presentation.resetPinCode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bluevelvet.blueprint.auth.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPinCodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_pin_code, container, false)
    }
}