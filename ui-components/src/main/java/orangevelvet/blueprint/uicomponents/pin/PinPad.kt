package orangevelvet.blueprint.uicomponents.pin

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import orangevelvet.blueprint.style.view.gone
import orangevelvet.blueprint.style.view.visible
import orangevelvet.blueprint.uicomponents.R
import orangevelvet.blueprint.uicomponents.databinding.PinPadBinding

class PinPad : LinearLayout {

    companion object {
        private const val DEFAULT_PIN_LENGTH = 6
    }

    interface PinPadCallBack {
        /**
         * Listener method invoked when the PIN changed (either a new digit added or an old one removed)
         *
         * @param pinCode - new pin
         */
        fun onChange(pinCode: String)
        /**
         * Listener method invoked when the PIN is complete
         *
         * @param pinCode - new pin
         */
        fun onFinish(pinCode: String)
    }

    private lateinit var binding: PinPadBinding
    private var mPinLength: Int = DEFAULT_PIN_LENGTH
    private var mPinPadListener: PinPadCallBack? = null

    private var mPinCode: String = ""
    val pinCode: String
        get() = mPinCode

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView(context, attrs, defStyle)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context, attrs, 0)
    }

    private fun initView(context: Context, attrs: AttributeSet, defStyle: Int) {
        binding = PinPadBinding.inflate(
            LayoutInflater.from(context), this, true
        )

        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.PinPad, defStyle, 0)
            .apply {
                try {
                    if (hasValue(R.styleable.PinPad_pinLength)) {
                        mPinLength = getInt(R.styleable.PinPad_pinLength, DEFAULT_PIN_LENGTH)
                    }

                    if (hasValue(R.styleable.PinPad_hasBiometric)
                        && (getBoolean(R.styleable.PinPad_hasBiometric, true))) {
                        binding.btnPinBiometrics.visible()
                    } else {
                        binding.btnPinBiometrics.gone()
                    }

                    if (hasValue(R.styleable.PinPad_android_enabled)) {
                        isEnabled = getBoolean(R.styleable.PinPad_android_enabled, true)
                    }
                } finally {
                    recycle()
                }
            }

        binding.btnPin0.setOnClickListener { addToPinCode(0) }
        binding.btnPin1.setOnClickListener { addToPinCode(1) }
        binding.btnPin2.setOnClickListener { addToPinCode(2) }
        binding.btnPin3.setOnClickListener { addToPinCode(3) }
        binding.btnPin4.setOnClickListener { addToPinCode(4) }
        binding.btnPin5.setOnClickListener { addToPinCode(5) }
        binding.btnPin6.setOnClickListener { addToPinCode(6) }
        binding.btnPin7.setOnClickListener { addToPinCode(7) }
        binding.btnPin8.setOnClickListener { addToPinCode(8) }
        binding.btnPin9.setOnClickListener { addToPinCode(9) }
        binding.btnPinDel.setOnClickListener { removeLastDigitFromPinCode() }
    }

    private fun addToPinCode(number: Int) {
        if (mPinCode.length < mPinLength) {
            mPinCode += number.toString()
            mPinPadListener?.onChange(mPinCode)

            if (mPinCode.length == mPinLength) {
                mPinPadListener?.onFinish(mPinCode)
            }
        }
    }

    private fun removeLastDigitFromPinCode() {
        if (mPinCode.isNotEmpty()) {
            mPinCode = mPinCode.dropLast(1)
            mPinPadListener?.onChange(mPinCode)
        }
    }

    fun setPinPadListener(listener: PinPadCallBack) {
        mPinPadListener = listener
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        binding.btnPin0.isEnabled = enabled
        binding.btnPin1.isEnabled = enabled
        binding.btnPin2.isEnabled = enabled
        binding.btnPin3.isEnabled = enabled
        binding.btnPin4.isEnabled = enabled
        binding.btnPin5.isEnabled = enabled
        binding.btnPin6.isEnabled = enabled
        binding.btnPin7.isEnabled = enabled
        binding.btnPin8.isEnabled = enabled
        binding.btnPin9.isEnabled = enabled
        binding.btnPinDel.isEnabled = enabled
        binding.btnPinBiometrics.isEnabled = enabled
    }

    /**
     * Call this method when you want clear the pin code to sync the PinView and PinPad
     */
    fun resetPinCode() {
        mPinCode = ""
    }
}
