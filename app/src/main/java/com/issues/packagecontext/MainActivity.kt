package com.issues.packagecontext

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logInstalledPackagesNames()

//        var fileName = createPackageContext("android", Context.CONTEXT_IGNORE_SECURITY).getPackageCodePath()
//        // This wrongly returns this packages' name which can lead to many issues depending on where/how this is being used.
//        Log.d("++", "FileName: $fileName")
//
//        fileName = packageManager.getApplicationInfo("android", 0).sourceDir
//        Log.d("++", "FileName2: $fileName")
//
//        try {
//            fileName = createPackageContext("xyz", Context.CONTEXT_IGNORE_SECURITY).getPackageCodePath()
//        } catch (ex: Exception) {
//            Log.d("++", "Exception with xyz")
//        }
//
//        val packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
//        for (packageInfo in packages) {
//            Log.d(
//                "++",
//                "Installed package :" + packageInfo.packageName
//            )
//            Log.d("++", "Source dir : " + packageInfo.sourceDir)
//        }
    }

    private fun logInstalledPackagesNames() {
        val packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        for (packageInfo in packages) {
            if (packageInfo.packageName == "android") {
                Log.d(
                    "++",
                    "Installed package :" + packageInfo.packageName
                )
                Log.d(
                    "++",
                    "Installed package : " + createPackageContext(
                        packageInfo.packageName,
                        Context.CONTEXT_IGNORE_SECURITY
                    ).packageName
                )
            }
        }
    }
}