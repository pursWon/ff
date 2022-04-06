package com.khs.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.khs.databinding.FragmentMainBinding
import com.khs.doublerecyclerviewusingdatabindingexampleproject.adapter.OutRecyclerViewAdapter
import com.khs.model.RecyclerInViewModel
import com.khs.model.RecyclerOutViewModel

class MainFragment: Fragment() {

    lateinit var binding: FragmentMainBinding // 뷰바인딩을 선언. lateinit은 늦은 초기화.
    // 개발자가 작성한 레이아웃 파일들을 바인딩클래스로 자동변환 : fragment_main.xml -> FragmentMainBinding
    // 늦은 초기화를 사용하면 프로퍼티의 선언과 동시에 초기화하지 않아도 된다

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
    // 프로퍼티 값을 초기화해서 사용하였다.
    // inflate는 xml에 표기된 레이아웃들은 메모리에 객체화.
        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {
        var itemList = mutableListOf(
            RecyclerOutViewModel("포유류", mutableListOf(
                RecyclerInViewModel("🐶", "강아지"), RecyclerInViewModel("🐱", "고양이"),
                RecyclerInViewModel("🐳", "고래"), RecyclerInViewModel("🦒", "사슴")
            )
            ),

            RecyclerOutViewModel("조류", mutableListOf(
                RecyclerInViewModel("🦅", "독수리"), RecyclerInViewModel("🕊️", "비둘기"),
                RecyclerInViewModel("🦉", "부엉이"), RecyclerInViewModel("🐔", "닭")
            )
            ),

            RecyclerOutViewModel("어류", mutableListOf(
                RecyclerInViewModel("🐟", "홍어"), RecyclerInViewModel("🐟", "광어"),
                RecyclerInViewModel("🐟", "연어"), RecyclerInViewModel("🐟", "우럭")
            )
            ),

            RecyclerOutViewModel("파충류", mutableListOf(
                RecyclerInViewModel("🐊", "악어"), RecyclerInViewModel("🦎", "카멜레온"),
                RecyclerInViewModel("🦎", "도마뱀"), RecyclerInViewModel("🐍", "뱀")
            )
            ),

            RecyclerOutViewModel("양서류", mutableListOf(
                RecyclerInViewModel("🐸", "개구리"), RecyclerInViewModel("🦎", "도룡뇽"),
                RecyclerInViewModel("🐸", "두꺼비")
            )
            ),
        )

        binding.outRecyclerview.adapter = OutRecyclerViewAdapter(requireContext(), itemList)
        binding.outRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }
}

// 뷰 바인딩을 사용하였고, 바깥쪽 리사이클러뷰의 어댑터와 모양을 결정해주는 코드가 있다.
// 이때, 리스트도 만들어 주었는데, 리스트 안에 리스트가 안쪽 리사이클러뷰에서 보여줄 내용들이다.

