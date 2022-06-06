package com.example.raktadana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDonor.setOnClickListener{
            startActivity(Intent(this,DonorActivity::class.java))
        }

        btnHos.setOnClickListener {
            startActivity(Intent(this, HospitalActivity::class.java))
        }
        btnRecvMain.setOnClickListener {
            startActivity(Intent(this, RecieverActivity::class.java))
        }
    }
}