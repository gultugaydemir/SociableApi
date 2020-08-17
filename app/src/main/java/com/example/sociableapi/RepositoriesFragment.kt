package com.example.sociableapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recyclerview.*

@SuppressLint("ParcelCreator")
class RepositoriesFragment() : Fragment(), Parcelable {

    private val repositoryList = arrayListOf<Repository>()

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.recyclerview, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(repositoryList, this)
        }

        JSONData(this).execute("https://github-trending-api.now.sh/repositories")
    }

    fun downloadFinished(repositories: ArrayList<Repository>) {
        repositoryList.clear()
        repositoryList.addAll(repositories)
        if(list_recycler_view != null)
            list_recycler_view.adapter?.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(): RepositoriesFragment = RepositoriesFragment()
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }


}