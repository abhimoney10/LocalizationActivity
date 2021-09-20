package com.mb.localizationactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var title_tv : TextView
    private var title = ""
    private lateinit var conditions :DownloadConditions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title_tv = findViewById(R.id.title_tv)
      findViewById<Button>(R.id.en_bt).setOnClickListener(this)
      findViewById<Button>(R.id.ch_bt).setOnClickListener(this)
      findViewById<Button>(R.id.hd_bt).setOnClickListener(this)

      title = title_tv.text.toString()



         conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.hd_bt ->{
                translateToHindi()
            }

            R.id.ch_bt->{
                translateToChina()
            }
            R.id.en_bt ->{
                translateToEng()
            }
        }

    }

    private fun translateToEng(){

        /*Create a Translator object, configuring it with the source and target languages*/
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.ENGLISH)
            .build()

        val englishGermanTranslator = Translation.getClient(options)
        /*Download Translation Model */
        englishGermanTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
               "Translate source to target language"
                englishGermanTranslator.translate(title)
                    .addOnSuccessListener { translatedText ->
                        title_tv.setText(translatedText)

                    }
                    .addOnFailureListener { exception ->
                        Log.e("========","      " + exception)
                    }
            }
            .addOnFailureListener { exception ->
                Log.e("========","      " + exception)
            }
    }
    private fun translateToChina(){
        /*Create a Translator object, configuring it with the source English and target languages China*/
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.CHINESE)
            .build()
        val englishGermanTranslator = Translation.getClient(options)
        /*Download Translation Model */
        englishGermanTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                /*"Translate source to target language"*/
                englishGermanTranslator.translate(title)
                    .addOnSuccessListener { translatedText ->
                        title_tv.setText(translatedText)

                    }
                    .addOnFailureListener { exception ->
                        Log.e("========","      " + exception)
                    }
            }
            .addOnFailureListener { exception ->
                Log.e("========","      " + exception)
            }
    }
    private fun translateToHindi(){
        /*Create a Translator object, configuring it with the source English and target languages Hindi*/
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.HINDI)
            .build()
        val englishGermanTranslator = Translation.getClient(options)
        /*Download Translation Model */
        englishGermanTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                /*"Translate source to target language"*/
                englishGermanTranslator.translate(title)
                    .addOnSuccessListener { translatedText ->
                        title_tv.setText(translatedText)

                    }
                    .addOnFailureListener { exception ->
                        Log.e("========","      " + exception)
                    }
            }
            .addOnFailureListener { exception ->
                Log.e("========","      " + exception)
            }
    }
}