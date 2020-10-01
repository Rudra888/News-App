package com.example.rudra888.newsappcompleted

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NewsAdapter(context : Context, arrayList : ArrayList<Data>) : BaseAdapter() {

    var arrayList : ArrayList<Data> = ArrayList()
    var context : Context?

    init {
        this.arrayList = arrayList
        this.context = context
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val holder : ViewHolder

        val inflater : LayoutInflater
                = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if(convertView == null){

            holder = ViewHolder()

            view = inflater.inflate(R.layout.list_item,parent,false)

            holder.sectionName = view.findViewById(R.id.section_name_text_view)
            holder.webTitle = view.findViewById(R.id.news_title_text_view)

            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder

        }

        val sectionNameValue = holder.sectionName
        sectionNameValue?.text = arrayList[position].sectionName

        val title = holder.webTitle
        title?.text = arrayList[position].webTitle

        title?.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(arrayList[position].webUrl))
            context!!.startActivity(browserIntent)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    class ViewHolder{
        var sectionName : TextView? = null
        var webTitle: TextView? = null
    }
}