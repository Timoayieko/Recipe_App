package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.recipeapp.database.RecipeDatabase
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.retrofitclient.RetrofitClientInstance
import com.example.recipeapp.interfaces.GetDataService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class SplashScreenActivity : BaseActivity(), EasyPermissions.RationaleCallbacks, EasyPermissions.PermissionCallbacks {
    private var READ_STORAGE_PERMISSON = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        readStorageTask()
        val start_btn: Button = findViewById<Button>(R.id.start_btn)
        val progress: ProgressBar = findViewById<ProgressBar>(R.id.loading)
        start_btn.setOnClickListener{
            progress.visibility = View.VISIBLE
            var intent = Intent(this@SplashScreenActivity, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories(){
        val service = RetrofitClientInstance.RetrofitInstance?.create(GetDataService::class.java)
        val call = service?.getCategoryList()
        if (call != null) {
            call.enqueue(object : Callback<Category>{
                override fun onResponse(
                    call: Call<Category>,
                    response: Response<Category>
                ) {
                    insertDataToRoomDb(response.body())
                }

                override fun onFailure(call: Call<Category>, t: Throwable) {
                    val progress: ProgressBar = findViewById<ProgressBar>(R.id.loading)
                    progress.visibility = View.INVISIBLE
                    Toast.makeText(this@SplashScreenActivity, "Something went wrong :(", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    fun insertDataToRoomDb(category: Category?){
        CoroutineScope().launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashScreenActivity).recipeDao().clearDb()
                for (arr in category!!.categoriesitem!!){
                    RecipeDatabase.getDatabase(this@SplashScreenActivity)
                        .recipeDao().insertCategory(arr)
                }
            }
        }
    }

    private fun hasReadStorage(): Boolean{
        return EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }
    private fun readStorageTask(){
        if(!hasReadStorage()){
            getCategories()
        }else{
            EasyPermissions.requestPermissions(
                this,
                "This app needs access to your storage",
                READ_STORAGE_PERMISSON,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
    override fun onRationaleAccepted(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onRationaleDenied(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)){
            AppSettingsDialog.Builder(this).build()
        }
    }
}