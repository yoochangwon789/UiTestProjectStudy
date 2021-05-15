package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        // Realm 을 사용하기 위해 init 해준다
        Realm.init(this)
        // Realm 을 사용하기 위해서 초기화 셋팅을 하고 config 해줘야 한다
        // Migration -> 데이터 베이스 용어 데이터 베이스를 동기화 시켜주겠다 라는 의미
        // 동기화 라는 것은 예를 들어 테이블의 필드가 추가 되었을 때를 말하고 데이터 베이스의 틀이 바뀌었을 때
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()

        // Realm set 해주기
        Realm.setDefaultConfiguration(config)

        // Realm 을 얻어오기
        val realm = Realm.getDefaultInstance()

        realm_btn_save.setOnClickListener {
            realm.executeTransaction{
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }

        realm_btn_load.setOnClickListener {
            realm.executeTransaction{
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data" + data)
            }
        }

        realm_btn_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }
    }
}