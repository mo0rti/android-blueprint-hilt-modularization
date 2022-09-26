package bluevelvet.blueprint.navigation.navigator

import android.os.Bundle
import androidx.annotation.IdRes

data class StartDestination(
    @IdRes val destination: Int,
    val args: Bundle? = null
)