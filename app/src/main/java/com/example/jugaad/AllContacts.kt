package com.example.jugaad

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_all_contacts.*
import android.widget.Toast
import android.widget.AdapterView.OnItemLongClickListener
import androidx.appcompat.app.AppCompatActivity


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AllContacts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_contacts)
        readContacts()
    }

    private fun readContacts(){

        val cursor: Cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,null,null,null)
        startManagingCursor(cursor)

        val from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID)

        val to = intArrayOf(android.R.id.text1,android.R.id.text2)

        val simple = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to)
        allListView.adapter = simple

        allListView.onItemLongClickListener = OnItemLongClickListener { arg0, arg1, arg2, arg3 ->
            val i = arg2 + 1
            Toast.makeText(this@AllContacts, "Long Clicked Trigger : ${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME}", Toast.LENGTH_LONG).show()
            true
        }

    }
}
