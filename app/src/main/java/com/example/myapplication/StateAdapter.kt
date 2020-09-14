package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.activeTv
import kotlinx.android.synthetic.main.activity_main.view.confirmedTv
import kotlinx.android.synthetic.main.activity_main.view.deceasedTv
import kotlinx.android.synthetic.main.activity_main.view.recoveredTv
import kotlinx.android.synthetic.main.item_list.view.*

class StateAdapter (val list: List<StatewiseItem>):BaseAdapter() {
    override fun getView(position : Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
        val item = list[position]
        view.confirmedTv.text =  SpannableDelta("${item.confirmed}\n ↑${item.deltaconfirmed?:"0" }",color ="#D32F2F", start = item.confirmed?.length?:0 )
        view.activeTv.text =  SpannableDelta("${item.active}\n ↑${item.deltaactive?:"0" }",color ="#1976D2", start = item.active?.length?:0 )
        view.recoveredTv.text =  SpannableDelta("${item.recovered}\n ↑${item.deltarecovered?:"0" }",color ="#388E3C", start = item.recovered?.length?:0 )
        view.deceasedTv.text =  SpannableDelta("${item.deaths}\n ↑${item.deltadeaths?:"0" }",color ="#FBC02D", start = item.deaths?.length?:0 )
        view.stateTv.text = item.state
        return view
    }

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = list.size

}