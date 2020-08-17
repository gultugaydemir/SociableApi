package com.example.sociableapi

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RepositoryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

    private var mAuthorView: TextView? = null
    private var mTitleView: TextView? = null
    private var mDescriptionView: TextView? = null
    private var mLanguageView: TextView? = null
    private var mStarsView: TextView? = null
    var mAuthorImageView: ImageView

    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mAuthorImageView = itemView.findViewById(R.id.list_avatar)
        mDescriptionView = itemView.findViewById(R.id.list_description)
        mLanguageView = itemView.findViewById(R.id.list_language)
        mStarsView = itemView.findViewById(R.id.list_stars)
    }

    fun bind(mRepository: Repository) {
        mTitleView?.text = mRepository.title
        mAuthorView?.text = mRepository.author
        mDescriptionView?.text = mRepository.description
        mLanguageView?.text = mRepository.language
        mStarsView?.text = mRepository.stars.toString()

    }
}
