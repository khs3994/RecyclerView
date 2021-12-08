package com.example.androidstudy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProfileAdapter(private val context: Context):RecyclerView.Adapter<ProfileAdapter.ViewHolder>(){

    var datas = mutableListOf<ProfileData>()//프로필 데이터 형태를 가진 뮤타블 리스트 생성

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)//리사이클러 뷰의 리스트 형태를 item_recycler로 선언
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = datas.size//아이템의 크기

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val Name: TextView = itemView.findViewById(R.id.tv_rv_name)
        private val Age: TextView = itemView.findViewById(R.id.tv_rv_age)
        private val img: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: ProfileData){
            Name.text = item.name
            Age.text = item.age.toString()
            Glide.with(itemView).load(item.img).into(img)
        }

    }


}