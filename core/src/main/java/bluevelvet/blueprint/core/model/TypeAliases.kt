package bluevelvet.blueprint.core.model

import android.view.LayoutInflater
import android.view.ViewGroup

typealias ViewInflater<T> = (LayoutInflater, ViewGroup?, Boolean) -> T