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
    private lateinit var service: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        service = RetrofitClient
            .getInstance()
            .create(AlbumService::class.java)

//        getRequestWithQueryParameters()
//        getRequestWithPathParameters()
        uploadAlbum()
    }
    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = service.getSortedAlbums(3)
            emit(response)
        }
        responseLiveData.observe(this, {
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
    private fun getRequestWithPathParameters() {
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = service.getAlbum(3)
            emit(response)
        }
        pathResponse.observe(this, {
            var title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()

        })
    }
    private fun uploadAlbum() {
        val album = AlbumsItem(101, "Hello!", 3)

        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = service.uploadAlbum(album)
            emit(response)
        }
        postResponse.observe(this, {
            val receivedAlbumsItem = it.body()
            val result =
                " Album Title : ${receivedAlbumsItem?.title}\n" +
                        " Album Id : ${receivedAlbumsItem?.id}\n" +
                        " Album UserId : ${receivedAlbumsItem?.userId}\n\n"
            binding.tv1.text = result
        })
    }
}