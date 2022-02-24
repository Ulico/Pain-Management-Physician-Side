package com.adrianrusso.painmanagementphysicianside.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.adrianrusso.painmanagementphysicianside.R
import com.adrianrusso.painmanagementphysicianside.models.Patient

class PatientListAdapter(val context: Context, private var list: List<Patient>) :
    BaseAdapter() {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = convertView ?: inflater.inflate(R.layout.list_item_patient, parent, false)
        val nameTextView = rowView.findViewById(R.id.nameText) as TextView
        val ageTextView = rowView.findViewById(R.id.ageText) as TextView
        val statusImageView = rowView.findViewById(R.id.statusImageView) as ImageView
        val name = list[position].name
        (name.substringAfterLast(" ") + ", " + name.substringBeforeLast(" ")).also {
            nameTextView.text = it
        }
        ageTextView.text = list[position].age.toString()
        statusImageView.setImageResource(if (list[position].status) R.drawable.ic_baseline_check_24 else R.drawable.ic_baseline_clear_24)

        return rowView
    }


    fun updateData(newList: List<Patient>) {
        list = newList
        notifyDataSetChanged()
    }

}