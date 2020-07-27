package com.home.kotlincoroutinedemo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.home.kotlincoroutinedemo.databinding.ActivityMainRecyclerViewItemBinding
import com.home.kotlincoroutinedemo.model.MainBean

class MainAdapter(
    private val list: MutableList<MainBean>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var setOnItemClickListener: ((MainBean) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityMainRecyclerViewItemBinding
            .inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean = list[position]
        holder.bindData(bean, setOnItemClickListener)
    }

    class ViewHolder(binding: ActivityMainRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val rootConstraintLayout: ConstraintLayout = binding.constraintLayoutRoot
        private val titleTextView: TextView = binding.textViewTitle
        private val bodyTextView: TextView = binding.textViewBody

        fun bindData(bean: MainBean, listener: ((MainBean) -> Unit)?) {
            bean.apply {
                rootConstraintLayout.setOnClickListener { listener?.invoke(this) }
                titleTextView.text = title
                bodyTextView.text = body
            }
        }
    }
}