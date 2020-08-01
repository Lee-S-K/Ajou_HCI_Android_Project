package com.sklee.asd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.android.synthetic.main.activity_intent1.*

class a : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        imageView.setOnClickListener{

            val intent = Intent(this@a,b::class.java)//다음 화면으로이동하기 위한 인텐트
            //두번째에는 이동할 엑티비티
            startActivity(intent)

        }



    }
}
