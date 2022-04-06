package com.khs.activity //이중 리사이클러 뷰 샘플 프로젝트

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khs.databinding.ActivityMainBinding
import com.khs.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding //lateinit으로 초기화를 늦추기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //메인 레이아웃을 뷰바인딩을 통해서 표출

        setContentView(binding.root) //setContentView에서는 binding.root를 꼭 전달

        supportFragmentManager.beginTransaction().replace(binding.container.id, MainFragment()).commit()
    }

    // 뷰바인딩을 사용하였고, onCreate가 될 때, supportFrametManager를 통해서 MainFragment를 띄우도록 했다.
}