package com.example.uitestproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this))
        val test = findViewById<ListView>(R.id.list_view_item_test)
        test.adapter = adapter

        test.setOnItemClickListener { parent, view, position, id ->
            // 해당 하는 item position 의 값을 가져옴
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this, carName + " " + carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater: LayoutInflater) :
    BaseAdapter() {

    // 내가 가지고 있는 List 의 숫자를 알려줘야함 즉 전체 갯수를 알려줘야함
    override fun getCount(): Int {
        return carForList.size
    }

    // 리스트를 알려줘야하는데 리스트의 하나를 알려준다 즉 해당 인덱스의 해당하는 아이템 정보를 알려준다 ->
    // 그리고자 하는 아이템 리스트의 한개 -> 아이템을 한개 가져오는 부분(포지션에 해당하는 부분)
    override fun getItem(position: Int): Any {
        return carForList.get(position)
    }

    // 리스트를 그리게 되면 리스트 마다 아이디를 부여해주는 부분 -> 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 뷰를 그리고자 하는 아이템 리스트의 전체 갯수
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view = layoutInflater.inflate(R.layout.item_view, null)
//
//        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.setText(carForList.get(position).name)
//        carEngineTextView.setText(carForList.get(position).engine)
//
//        return view

        val view: View
        val holder: ViewHolder

        // convertView 재활용 뷰 도는 뷰
        if (convertView == null) {
            // 재활용 되는 뷰가 없다면 즉 처음에 뷰는 없으니까 조건 성립

            Log.d("holder", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            // ViewHolder 도 처음이니까 만들어 줘야한다
            holder = ViewHolder()

            // 우리가 만들어준 view 를 holder 에 집어 넣어 준다
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            // 찾을 수 있도록 tag 를 달아준다
            view.tag = holder

            // 뷰를 재사용 할게 있다라면
        } else {
            Log.d("holder", "2")
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        // 뷰를 넣어주는 것은 그대로 한다
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }

}

// findViewById 함수는 매우 무거우므로 holder 에 쓸 view 를 담아놓고 돌려서 쓰기 위한 holder 선언 클래스
class ViewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}