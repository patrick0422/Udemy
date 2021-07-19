package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitdemo.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val service = RetrofitClient
            .getInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = service.getSortedAlbums(3)
            emit(response)
        }

        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = service.getAlbum(3)
            emit(response)
        }
        pathResponse.observe(this, Observer {
            var title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()

        })

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()

            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumsItem = albumList.next()
                    val result =
                        " Album Title : ${albumsItem.title}\n" +
                        " Album Id : ${albumsItem.id}\n" +
                        " Album UserId : ${albumsItem.userId}\n\n"
                    binding.tv1.append(result)

                    Log.i("MyTag", albumsItem.title)
                }
            }
        })
    }
}