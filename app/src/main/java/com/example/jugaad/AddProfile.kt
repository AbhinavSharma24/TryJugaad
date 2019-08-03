package com.example.jugaad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_profile.*

class AddProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile)

        dummy.requestFocus()
        dummy.isFocusableInTouchMode = true

        addProfileBtn.setOnClickListener {
            startActivity(Intent(this,AddedList::class.java))
        }
    }
}
