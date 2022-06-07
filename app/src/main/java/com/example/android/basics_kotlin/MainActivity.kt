package com.example.android.basics_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView : RecyclerView = findViewById(R.id.list)
        listView.layoutManager = LinearLayoutManager(this)
        val item = fetchData()
        val adapter = NewListAdapter(item,this)
        listView.adapter = adapter
    }
    private fun fetchData():ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("Item $i")
        }
        return list
    }

    override fun OnItemClicked(items: String) {
       Toast.makeText(this,"Item Clicked $items",Toast.LENGTH_LONG).show()
    }
}