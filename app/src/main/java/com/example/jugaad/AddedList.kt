package com.example.jugaad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_profile.*
import kotlinx.android.synthetic.main.activity_all_contacts.*

class AddedList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_added_list)

        val name = arrayOf(etfirstname.text.toString() + etsamename.text.toString())
        val phoneno = arrayOf(etphoneno.text.toString())

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_2,name)
        allListView.adapter = adapter
    }
}
