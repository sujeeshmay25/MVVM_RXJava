package com.example.pathwayhub_sujeesh.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pathwayhub_sujeesh.R
import com.example.pathwayhub_sujeesh.network.PathPojo


class PathAdapter : RecyclerView.Adapter<PathAdapter.MyViewHolder>() {
    var listData = ArrayList<PathPojo.Response.Doc>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row,parent,false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        lateinit var  tvId :TextView
        lateinit var tvDate:TextView
        lateinit var tvType:TextView
        lateinit var tvAbstarct:TextView

        init {
            tvId=view.findViewById(R.id.tv_idval)
            tvDate=view.findViewById(R.id.tv_pubdate)
            tvType=view.findViewById(R.id.tv_type)
            tvAbstarct=view.findViewById(R.id.tv_abstract)
        }


        fun bind(data : PathPojo.Response.Doc) {
            tvId.text=data.id
            tvDate.text=data.publication_date
            tvType.text=data.article_type
            tvAbstarct.text=data.abstract.get(0)

        }
    }
}