package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val start_btn: Button = findViewById<Button>(R.id.start_btn)
        val progress: ProgressBar = findViewById<ProgressBar>(R.id.loading)
        start_btn.setOnClickListener{
            progress.visibility = View.VISIBLE
            var intent = Intent(this@SplashScreenActivity, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}