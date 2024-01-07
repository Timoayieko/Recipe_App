package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.retrofitclient.RetrofitClientInstance
import com.example.recipeapp.interfaces.GetDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

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

//    fun getCategories(){
//        val service = RetrofitClientInstance.RetrofitInstance?.create(GetDataService::class.java)
//        val call = service?.getCategoryList()
//        if (call != null) {
//            call.enqueue(object : Callback<List<Category>>{
//                override fun onResponse(
//                    call: Call<List<Category>>,
//                    response: Response<List<Category>>
//                ) {
//                    insertDataToRoomDb(response.body())
//                }
//
//                override fun onFailure(call: Call<List<Category>>, t: Throwable) {
//                    val progress: ProgressBar = findViewById<ProgressBar>(R.id.loading)
//                    progress.visibility = View.INVISIBLE
//                    Toast.makeText(this@SplashScreenActivity, "Something went wrong :(", Toast.LENGTH_SHORT).show()
//                }
//
//            })
//        }
//    }

//    fun insertDataToRoomDb(category: List<Category>?){
//
//    }
}