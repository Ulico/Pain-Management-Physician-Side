package com.example.painmanagementphysicianside.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.painmanagementphysicianside.R
import com.example.painmanagementphysicianside.models.Patient

class PatientListAdapter(val context: Context, private var dataSource: List<Patient>) :
    BaseAdapter() {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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
        val nameTextView = rowView.findViewById(R.id.nameText) as TextView
        val ageTextView = rowView.findViewById(R.id.ageText) as TextView
        val statusImageView = rowView.findViewById(R.id.statusImageView) as ImageView
        val name = dataSource[position].name
        (name.substringAfterLast(" ") + ", " + name.substringBeforeLast(" ")).also {
            nameTextView.text = it
        }
        ageTextView.text = dataSource[position].age.toString()
        statusImageView.setImageResource(if (dataSource[position].status) R.drawable.ic_baseline_check_24 else R.drawable.ic_baseline_clear_24)

        return rowView
    }


    fun updateData(newDatSource: List<Patient>) {
        dataSource = newDatSource
        notifyDataSetChanged()
    }

}