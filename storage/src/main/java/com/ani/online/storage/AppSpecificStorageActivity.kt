package com.ani.online.storage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.StringBuilder

class AppSpecificStorageActivity : AppCompatActivity() {

    val TAG = AppSpecificStorageActivity::class.java.canonicalName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_specific_storage)

        Log.i(TAG, "Files Dir - $filesDir")
        Log.i(TAG, "Cache Dir - $cacheDir")
        Log.i(TAG, "External Files Dir - ${getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)}")

        writePrivateData()

        readPrivateData()

        writeOnNonSharedPublicStorage()

        readFromNonSharedPublicStorage()
    }

    private fun writePrivateData() {
        openFileOutput("my.txt", Context.MODE_PRIVATE).use {
            it.write("Hello world".toByteArray())
        }
    }

    private fun readPrivateData() {
//        openFileInput("my.txt").use {
//            it.bufferedReader().useLines { lines ->
//                val dt = lines.fold("") { some, text ->  "$some\n$text" }
//                Log.i(TAG, "File Data $dt")
//            }
//        }

        val fl = File(filesDir, "my.txt")
        openFileInput("my.txt").use {
            val bytArr = ByteArray(fl.length().toInt())
            it.read(bytArr)
            Log.i(TAG, "File Data is ${String(bytArr)}")
        }
    }

    private fun writeOnNonSharedPublicStorage() {
        if (isExtWritable()) {
            val externalStorageVolumes: Array<out File> =
                ContextCompat.getExternalFilesDirs(applicationContext, null)
            externalStorageVolumes.forEach {
                Log.i(TAG, "Volume Name ${it.name}")
                Log.i(TAG, "Volume Path ${it.canonicalPath}")
            }
            val primaryExternalStorage = externalStorageVolumes[0]
            val file = File(primaryExternalStorage, "my.txt")
            val fos = FileOutputStream(file)
            fos.use {
                it.write("Hello world to external storage".toByteArray())
            }
            Log.i(TAG, "Data Written to external storage")
        }
    }

    private fun readFromNonSharedPublicStorage() {
        if (isExternalStorageReadable()) {
            val externalStorageVolumes: Array<out File> =
                ContextCompat.getExternalFilesDirs(applicationContext, null)
            val primaryExternalStorage = externalStorageVolumes[0]

            val file = File(primaryExternalStorage, "my.txt")
            val fis = FileInputStream(file)
            fis.use {
                it.bufferedReader().useLines { lines ->
                    val dt = lines.fold("") { some, text -> "$some\n$text" }
                    Log.i(TAG, "External File Data \n $dt")
                }
            }
        }
    }

    private fun isExtWritable() = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

    private fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }
}