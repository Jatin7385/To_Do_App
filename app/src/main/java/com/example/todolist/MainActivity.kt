package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataList : MutableList<ToDoModel> = ArrayList()
        val recview: RecyclerView = findViewById(R.id.recview)
        val edt : EditText = findViewById(R.id.edt)
        val add : Button = findViewById(R.id.addbtn)

        recview.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(dataList)
        recview.adapter = adapter

        add.setOnClickListener {
            val text = edt.text.toString()
            if(text.isNotEmpty())
            {
                val todo = ToDoModel(text,false)
                adapter.addItem(todo)
                edt.text.clear()
            }
        }

    }
}