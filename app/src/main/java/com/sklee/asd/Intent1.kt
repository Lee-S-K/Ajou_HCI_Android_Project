package com.sklee.asd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent1.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        다음.setOnClickListener {
            val intent = Intent(this@Intent1, Intent2::class.java)
            startActivity(intent)
        }
    }
}