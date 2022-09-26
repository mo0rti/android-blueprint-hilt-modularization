package bluevelvet.blueprint.uicomponents.pin

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.LinearLayout
import bluevelvet.blueprint.style.view.gone
import bluevelvet.blueprint.uicomponents.R
import bluevelvet.blueprint.uicomponents.databinding.PinPadButtonBinding

class PinPadButton : LinearLayout {

    private lateinit var binding: PinPadButtonBinding

    private var _wrappedOnClickListener: OnClickListener? = null

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView(context, attrs, defStyle)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context, attrs, 0)
    }

    private fun initView(context: Context, attrs: AttributeSet, defStyle: Int) {
        binding = PinPadButtonBinding.inflate(LayoutInflater.from(context), this, true)

        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.PinPadButton, defStyle, 0)
            .apply {
                try {
                    if (hasValue(R.styleable.PinPadButton_android_drawable)) {
                        binding.icPinButton.setImageDrawable(getDrawable(R.styleable.PinPadButton_android_drawable))
                    }

                    if (hasValue(R.styleable.PinPadButton_android_text)) {
                        binding.tvPinButton.text = getText(R.styleable.PinPadButton_android_text)
                    } else {
                        binding.tvPinButton.gone()
                    }

                    if (hasValue(R.styleable.PinPadButton_android_enabled)) {
                        isEnabled = getBoolean(R.styleable.PinPadButton_android_enabled, true)
                    }
                } finally {
                    recycle()
                }
            }
    }

    override fun setEnabled(enabled: Boolean) {
        binding.root.apply {
            isEnabled = enabled
            isClickable = enabled
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        _wrappedOnClickListener = l
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            _wrappedOnClickListener?.onClick(this)
        }
        return super.dispatchTouchEvent(event)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_UP && (event.keyCode == KeyEvent.KEYCODE_DPAD_CENTER || event.keyCode == KeyEvent.KEYCODE_ENTER)) {
            _wrappedOnClickListener?.onClick(this)
        }
        return super.dispatchKeyEvent(event)
    }
}
