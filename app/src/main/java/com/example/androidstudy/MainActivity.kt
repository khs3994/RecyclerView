package com.example.androidstudy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler(){
        profileAdapter = ProfileAdapter(this)
        val rv_profile: RecyclerView = findViewById(R.id.rv_profile)
        rv_profile.adapter = profileAdapter

        datas.apply {
            rv_profile.addItemDecoration(VerticalItemDecorator(20))//가로로 구분선 추가
            rv_profile.addItemDecoration(HorizontalItemDecorator(20))//세로로 구분선 추가
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name="mary", age = 24))
            add(ProfileData(img = R.drawable.ic_launcher_background, name="jenny", age = 26))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name="jhon", age = 27))
            add(ProfileData(img = R.drawable.ic_launcher_background, name="ruby", age = 21))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name="yuna", age = 23))
            add(ProfileData(img = R.drawable.ic_launcher_background, name="ruby", age = 21))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name="yuna", age = 23))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()
        }
    }
}