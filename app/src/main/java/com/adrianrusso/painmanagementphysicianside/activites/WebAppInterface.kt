package com.adrianrusso.painmanagementphysicianside.activites

import android.webkit.JavascriptInterface
import com.adrianrusso.painmanagementphysicianside.adapters.PatientListAdapter
import com.adrianrusso.painmanagementphysicianside.models.AppUser

class WebAppInterface(private val mContext: Patients, private val adapter: PatientListAdapter) {


    @JavascriptInterface

    fun insertID(): String {

        return adapter.getListNames()[0]

    }

}
