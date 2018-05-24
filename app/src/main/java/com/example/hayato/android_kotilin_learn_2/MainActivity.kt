package com.example.hayato.android_kotilin_learn_2

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoAsyncContext

import org.jetbrains.anko.apply
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = Preference(this)
        pref.setPreferenceText()
        save.setOnClickListener { pref.savePreference() }
        clear.setOnClickListener{ pref.clear()}
        heightButton.setOnClickListener{startActivity<HeightActivity>()}
    }


    inner class Preference(context: Context) {
        val neckKey = "NECK"
        val sleeveKey = "SLEEVE"
        val waistKey = "WAIST"
        val inseamKey = "INSEAM"
        val pref = PreferenceManager.getDefaultSharedPreferences(context)

        fun setPreferenceText() {
            neck.setText(pref.getString(neckKey, ""))
            sleeve.setText(pref.getString(sleeveKey, ""))
            waist.setText(pref.getString(sleeveKey, ""))
            inseam.setText(pref.getString(inseamKey, ""))
        }

        fun savePreference() {
            pref.apply {
                putString(neckKey, neck.text.toString())
                putString(sleeveKey, sleeve.text.toString())
                putString(waistKey, waist.text.toString())
                putString(inseamKey, inseam.text.toString())
                apply()
            }
        }

        fun clear(){
            pref.edit().clear().apply()
            neck.setText("")
            sleeve.setText("")
            waist.setText("")
            inseam.setText("")
        }
    }
}



