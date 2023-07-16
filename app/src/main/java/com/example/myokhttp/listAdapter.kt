package com.example.myapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myokhttp.Listgp
import com.example.myokhttp.R

class listAdapter(activity: Activity, val resourceId: Int, data: List<Listgp>) : ArrayAdapter<Listgp>(activity,resourceId,data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourceId , parent,false)
        val vt1 : TextView = view.findViewById(R.id.tv1)
        val vt2 : TextView = view.findViewById(R.id.tv2)
        val vt3 : TextView = view.findViewById(R.id.tv3)
        val lsgp = getItem(position)
        if (lsgp != null){
            vt1.text =  lsgp.dm.toString()
            vt2.text =  lsgp.mc
            vt3.text = lsgp.jys
        }
        return view
    }
}