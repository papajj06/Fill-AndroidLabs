package com.example.clonestudy

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.clonestudy.databinding.ActivityMain2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity2 : AppCompatActivity() {

    val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnDownload.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch { // 코루틴의 메인 영역
                    progressBar.visibility = View.VISIBLE
                    val url = binding.etUrl.text.toString()

                    val bitmap = withContext(Dispatchers.IO) {
                        loadImage(url) // bitmap을 꺼내서 저장. 백그라운드 실행
                    }

                    imageView.setImageBitmap(bitmap)
                    progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }
}

suspend fun loadImage(imageUrl:String) : Bitmap {
    val url = URL(imageUrl)
    val stream = url.openStream()

    return BitmapFactory.decodeStream(stream)
}