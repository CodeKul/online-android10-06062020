package com.ani.online.storage

import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat

class AppSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        Log.i("@ani", "Root Key $rootKey")
        setPreferencesFromResource(R.xml.app_settings, rootKey)
    }
}