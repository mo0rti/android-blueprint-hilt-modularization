package bluevelvet.blueprint.core.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import bluevelvet.blueprint.core.domain.model.ViewInflater

abstract class BaseRecyclerViewAdapter<T, B: ViewDataBinding>
    constructor(
        private val viewInflater: ViewInflater<B>
    ): RecyclerView.Adapter<BaseRecyclerViewAdapter<T, B>.ViewHolder>() {

    companion object {
        fun <T, B: ViewDataBinding> build(
            viewInflater: ViewInflater<B>,
            bind: (T, B) -> Unit
        ): BaseRecyclerViewAdapter<T, B> {
            return object: BaseRecyclerViewAdapter<T, B>(viewInflater) {
                override fun bindData(item: T, binding: B) {
                    bind(item, binding)
                }
            }
        }
    }

    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    abstract fun bindData(item: T, binding: B)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: B = viewInflater.invoke(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: B) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            bindData(item, binding)
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int { return data.size }
}
