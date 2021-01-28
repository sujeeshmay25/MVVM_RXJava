package com.example.pathwayhub_sujeesh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.pathwayhub_sujeesh.adapter.PathAdapter
//import com.example.pathwayhub_sujeesh.db.AppDatabase1
import com.example.pathwayhub_sujeesh.network.PathPojo
import com.example.pathwayhub_sujeesh.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var pathAdapter: PathAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)

        apiCall()
        recyclerviewCall()
    }

    private fun recyclerviewCall() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decor= DividerItemDecoration(applicationContext,VERTICAL)
            addItemDecoration(decor)
            pathAdapter = PathAdapter()
            adapter = pathAdapter
        }
    }

    private fun apiCall() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getListObserver().observe(this, Observer<PathPojo>{
            println("List** "+it)
            if (it != null){
                pathAdapter.listData = it.response.docs
                pathAdapter.notifyDataSetChanged()
               // loadDb()
            }else{
                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.apiCall(this)
    }

  /* fun loadDb(){
       val db = AppDatabase1.getInstance(baseContext).pathDao()
       db.getValue()
       pathAdapter.listData = db.getValue()
       pathAdapter.notifyDataSetChanged()
   }*/
}