package com.example.myokhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ListView
import com.example.myapplication.listAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler(Looper.getMainLooper())

        Thread{
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://api.mairui.club/hslt/list/b2b0a8353913f554c")
                .build()

            val response = client.newCall(request).execute()

            val responseData = response.body?.string()
            handler.post{
                val gson = Gson()

                val typeOf = object : TypeToken<List<Listgp>>() {}.type

                val lsgp = gson.fromJson<List<Listgp>>(responseData, typeOf)

                val adapter = listAdapter(this, R.layout.listgp_item, lsgp)

                val listView: ListView = findViewById(R.id.listView)

                listView.adapter = adapter
            }

        }.start()








    }
}
