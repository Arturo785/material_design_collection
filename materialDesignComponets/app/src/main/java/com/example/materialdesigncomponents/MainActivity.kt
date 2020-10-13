package com.example.materialdesigncomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materialdesigncomponents.adapters.ListAdapterComponent
import com.example.materialdesigncomponents.models.Component
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListAdapterComponent.Interaction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testList()
    }

    fun testList(){
        val myList = mutableListOf<Component>()
        val myAdapter = ListAdapterComponent(this)

        for (i in 0..10){
            myList.add(Component(i.toString(), R.drawable.ic_launcher_background, 5))
        }
        myAdapter.differ.submitList(myList)
        recyclerView.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    override fun onItemSelected(position: Int, item: Component) {
        Toast.makeText(this,"clicked $position",Toast.LENGTH_SHORT).show()
    }
}