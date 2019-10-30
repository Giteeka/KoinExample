package com.app.koinexample.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.koinexample.databinding.RowUsersBinding
import com.app.koinexample.model.User

class ListUserAdapter(var list: List<User>, val onItemClick : ((user :User) -> Unit)) : RecyclerView.Adapter<ListUserAdapter.DataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val binding = RowUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataHolder(binding)
    }

    fun updateList(list: List<User>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.binding.user = list.get(position)
        holder.binding.executePendingBindings()
    }


    inner class DataHolder(var binding: RowUsersBinding) :
        RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                onItemClick(list.get(adapterPosition))
            }
        }
    }
}
