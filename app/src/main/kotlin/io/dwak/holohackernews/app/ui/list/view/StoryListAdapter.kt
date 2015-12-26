package io.dwak.holohackernews.app.ui.list.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import io.dwak.holohackernews.app.base.mvp.recyclerview.MvpAdapter
import io.dwak.holohackernews.app.model.json.StoryJson

class StoryListAdapter(context: Context)
: MvpAdapter<StoryViewHolder>() {

    private val inflater: LayoutInflater
    private val list = arrayListOf<StoryJson>()
    var onItemClicked : ((StoryJson) -> Unit)? = null
    var onSaveClicked : ((Boolean) -> Unit)? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    public fun addStory(story: StoryJson) {
        list.add(story)
        notifyItemInserted(list.size)
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = StoryViewHolder.create(inflater, parent!!)

    override fun onBindViewHolder(holder: StoryViewHolder?, position: Int) {
        holder?.bind(list[position], onItemClicked, onSaveClicked)
    }

}