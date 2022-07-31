package com.geektech.pixabay44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.geektech.pixabay44.databinding.ActivityMainBinding
import com.geektech.pixabay44.model.ImageModel
import com.geektech.pixabay44.model.PixabayModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var page=1
    var imageAdapter= ImageAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        binding.requestBtn.setOnClickListener {
            doRequest(page)
        }
        binding.clickBtn.setOnClickListener {
            doRequest(page++)
        }
    }

    private fun doRequest(page: Int) {
        App.api.getImagesByWorld(keyWord = binding.keyWord.text.toString(), page =page).
        enqueue(object:retrofit2.Callback<PixabayModel>{
            override fun onResponse(
                call: Call<PixabayModel>,
                response: Response<PixabayModel>
            ) {
                response.body()?.hits?.let {
                    imageAdapter= ImageAdapter(it as ArrayList<ImageModel>)
                    binding.recyclerView.adapter=imageAdapter
                }

                Log.e("ololo", "onResponce: ${response.body()?.hits}")
            }
            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Log.e("ololo", "onResponce: ${t.message}")
            }
        })

    }


}