package com.example.myapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var bind:ActivityMainBinding
    lateinit var myadapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)


        val retrofit = Retrofit.Builder() //object creation of Retrofit
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retroData = retrofit.getProduct() //fetching all data and calling getProduct from interface
        retroData.enqueue(object : Callback<MyData?> {
            override fun onResponse(p0: Call<MyData?>, res: Response<MyData?>) {

                if(res.isSuccessful && res != null){
                    val apidata = res.body()
                    val productList = apidata?.products!! //!! for ensuring not null value and get lst of products
                    myadapter = MyAdapter(this@MainActivity, productList)
                    bind.recyclerviewID.adapter = myadapter
                    bind.recyclerviewID.layoutManager = LinearLayoutManager(this@MainActivity)


                    //toDo show ratings stars accroding to ratings
                }
            }

            override fun onFailure(p0: Call<MyData?>, p1: Throwable) {
                Log.d("Main activity","OnFailure **** "+p1.message)
            }
        })
    }
}