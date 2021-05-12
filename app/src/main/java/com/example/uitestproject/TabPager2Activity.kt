package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*
import kotlinx.android.synthetic.main.activity_tab_pager2.*

class TabPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager2)

        tab_layout2.addTab(tab_layout2.newTab().setText("ONE"))
        tab_layout2.addTab(tab_layout2.newTab().setText("TWO"))
        tab_layout2.addTab(tab_layout2.newTab().setText("THREE"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this))
        val page = findViewById<ViewPager>(R.id.view_pager2)
        page.adapter = adapter
        page.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout2))

        tab_layout2.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                page.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}

class ThreePageAdapter(
    val layoutInflater: LayoutInflater,
) : PagerAdapter() {

    // 실제적으로 뷰를 그려주는 부분
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.fragment_two, container, false)
                container.addView(view)
                return view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
                container.addView(view)
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
        }
    }

    // 뷰가 사라질 때 파기될 때 호출이 되는 함수
    // object 가 뷰
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return 3
    }

    // 화면에 나와있는것이 내가 만든것이 맞습니까?
    // === 이것은 주소값을 비교
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }
}