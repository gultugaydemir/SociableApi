package com.example.sociableapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsFragment() : Fragment() {

    private var mTitle: String? = null
    private var mStars: Int? = null
    private var mForks: Int? = null
    private var mLanguage: String? = null
    private var mWatchers: String? = null
    private var mAvatar: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var args: Bundle? = arguments
        var mRepository: Repository = args?.get("data") as Repository
        mTitle = mRepository.title
        mStars = mRepository.stars
        mForks = mRepository.forks
        mAvatar = mRepository.user?.avatar
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view:View = inflater.inflate(R.layout.fragment_details, container, false)

        var titleView: TextView = view.findViewById(R.id.Title)
        titleView.text = mTitle

        var avatarView: ImageView = view.findViewById(R.id.details_avatar)
        Glide.with(this).load(mAvatar).into(avatarView)

        var watchersView: DetailListView = view.findViewById(R.id.DetailListWatchers)
        var watchers: TextView = watchersView.findViewById(R.id.DetailListNumber)
        watchers.text = mWatchers.toString()

        var starsView: DetailListView = view.findViewById(R.id.DetailListStars)
        var stars: TextView = starsView.findViewById(R.id.DetailListNumber)
        stars.text = mStars.toString()

        var forksView: DetailListView = view.findViewById(R.id.DetailListForks)
        var forks: TextView = forksView.findViewById(R.id.DetailListNumber)
        forks.text = mForks.toString()

        return view
    }

    companion object {
        fun newInstance(): DetailsFragment = DetailsFragment()
    }
}