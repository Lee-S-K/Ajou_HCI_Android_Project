package com.sklee.asd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class b : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        imageView5.setOnClickListener{

            val intent_a = Intent(this@b,c::class.java)

            startActivity(intent_a)
        }
    }
}