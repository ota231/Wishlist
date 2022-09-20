package com.example.wishlist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

var items: MutableList<Item> = ArrayList<Item>()
val adapter = ItemAdapter(items)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create variables for all the edit text views
        // these are the variables to be sent to the holder/adapter

        val item = findViewById<EditText>(R.id.nameEditText)
        val price = findViewById<EditText>(R.id.priceEditText)
        val url = findViewById<EditText>(R.id.urlEditText)

        //var userItem = findViewById<TextView>(R.id.nameEditText)
        //var userPrice = findViewById<TextView>(R.id.priceEditText)
        //var userURL = findViewById<TextView>(R.id.urlEditText)

        val itemRv = findViewById<RecyclerView>(R.id.itemRv)
        itemRv.adapter = adapter

        val submitButton = findViewById<Button>(R.id.submitButtom)

        submitButton.setOnClickListener(){
            hideSoftKeyboard()
            var userItem = item.getText().toString()
            var userPrice = price.getText().toString()
            var userURL = url.getText().toString()

            var actualItem = Item(userItem, userPrice, userURL)

            insertItem(actualItem)
        }

        itemRv.layoutManager = LinearLayoutManager(this)

    }

    fun insertItem(item: Item){
        items.add(0, item)
        adapter.notifyItemInserted(0)
    }

    fun Activity.hideSoftKeyboard(){
        (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }


}