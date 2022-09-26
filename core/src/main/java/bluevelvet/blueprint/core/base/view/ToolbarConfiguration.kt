package bluevelvet.blueprint.core.base.view

import androidx.annotation.StringRes

data class ToolbarConfiguration(
    val isVisible: Boolean = true,
    val title: String = "",
    @StringRes
    val titleRes: Int? = null,
    val hasBackNavIcon: Boolean = true
)