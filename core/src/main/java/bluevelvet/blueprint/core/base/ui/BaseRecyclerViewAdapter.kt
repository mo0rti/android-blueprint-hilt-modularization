package bluevelvet.blueprint.core.base.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import bluevelvet.blueprint.core.model.ViewInflater

abstract class BaseRecyclerViewAdapter<T, B : ViewDataBinding> :

    RecyclerView.Adapter<BaseRecyclerViewAdapter<T, B>.ViewHolder>() {

    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    abstract fun bindData(item: T, binding: B)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: B = getLayoutInflater(viewType).invoke(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return getViewType(position, data[position])
    }

    inner class ViewHolder(private val binding: B) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            bindData(item, binding)
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int { return data.size }

    abstract fun getViewType(position: Int, item: T): Int

    abstract fun getLayoutInflater(viewType: Int): ViewInflater<B>
}
