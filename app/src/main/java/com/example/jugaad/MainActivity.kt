package com.example.jugaad

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addbtn.setOnClickListener {
            startActivity(Intent(this,AddProfile::class.java))
        }

        requests()
    }

    private fun requests() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                1234
            )
            allbtn.setOnClickListener {
                requests()
            }
        }
        else {
            allbtn.setOnClickListener {
                startActivity(Intent(this, AllContacts::class.java))
            }
        }
    }

}