package com.example.androidstudy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.setbutton.setOnClickListener { initRecycler() }

        datas.apply {
            binding.rvProfile.addItemDecoration(VerticalItemDecorator(20))//가로로 구분선 추가
            //rv_profile.addItemDecoration(HorizontalItemDecorator(20))//세로로 구분선 추가
        }

    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler(){
        val str_usname = binding.username.text.toString()
        val it_usage = binding.userage.text.toString()
        profileAdapter = ProfileAdapter(this)
        binding.rvProfile.adapter = profileAdapter

        datas.apply {
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = str_usname, age = it_usage))
            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()
        }
    }
}