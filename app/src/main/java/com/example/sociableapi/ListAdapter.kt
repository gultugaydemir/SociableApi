package com.example.sociableapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAdapter(private val list: List<Repository>, var view: ViewGroup)
    : RecyclerView.Adapter<RepositoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RepositoryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository: Repository = list[position]
        holder.bind(repository)
        holder.itemView.setOnClickListener { view: View? ->
            var bundle = Bundle()
            bundle.putSerializable("data", repository)
            view?.findNavController()?.navigate(R.id.to_detailsFragment, bundle)
        }
        Glide.with(view).load(repository.user?.avatar).into(holder.mAuthorImageView)
    }

    override fun getItemCount(): Int = list.size
}