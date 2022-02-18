package com.example.painmanagementphysicianside.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.painmanagementphysicianside.R

class PatientListAdapter(context: Context) : BaseAdapter() {

    val dataSource = arrayOf("patients1", "patients2")

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = convertView ?: inflater.inflate(R.layout.list_item_patient, parent, false)
        val nameTextView = rowView.findViewById(R.id.name) as TextView
        nameTextView.text = dataSource[position]

        return rowView
    }

}