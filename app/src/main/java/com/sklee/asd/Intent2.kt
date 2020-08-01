package com.sklee.asd

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val Detail =
            findViewById<View>(R.id.Detail) as Button
        Detail.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivityForResult(intent, 99)
        }
        Skip.setOnClickListener {
            val intent = Intent(this@Intent2, BoardActivity::class.java)
            startActivity(intent)
        }
    }
}