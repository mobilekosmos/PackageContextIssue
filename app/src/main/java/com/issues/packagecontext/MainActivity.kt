package com.issues.packagecontext

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fileName = createPackageContext("android", Context.CONTEXT_IGNORE_SECURITY).getPackageCodePath()
        // This wrongly returns this packages' name which can lead to many issues depending on where/how this is being used.
        Log.d("++", "FileName: $fileName")
        try {
            fileName = createPackageContext("xyz", Context.CONTEXT_IGNORE_SECURITY).getPackageCodePath()
        } catch (ex: Exception) {
            Log.d("++", "Exception with xyz")
        }
    }
}