package mortitech.blueprint.core.domain.model

import android.view.LayoutInflater
import android.view.ViewGroup

typealias ViewInflater<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
