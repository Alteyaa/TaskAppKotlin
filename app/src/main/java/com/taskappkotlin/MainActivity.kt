package com.taskappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var imageView:ImageView

    var id: Int = 0

    val url_1 = "https://i.ytimg.com/vi/2Vv-BfVoq4g/sddefault.jpg"
    val url_2 = "https://i.imgur.com/uPMCQda.jpg"
    val url_3 = "https://i.imgur.com/U1trNIh.jpg"
    val url_4 = "https://i.imgur.com/IclyEVN.jpg"
    val url_5 = "https://i.imgur.com/NbO4gKo.jpg"
    val url_6 = "https://i.imgur.com/T03gMQO.jpg"

    val mutableList: List<String> = mutableListOf(url_1, url_2, url_3, url_4, url_5,url_6)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        changeImage()
    }

    private fun initView(){
        imageView = findViewById(R.id.imageView)
        mPrevBtn.setOnClickListener {
            id = id.dec()
            changeImage()
        }
        mNextBtn.setOnClickListener {
            id = id.inc()
            changeImage()
        }
    }

    private fun changeImage() {
        when(id){
            0 -> {
                mPrevBtn.visibility = View.GONE
            }
            mutableList.size - 1 ->{
                mNextBtn.visibility = View.GONE

            }
            else -> {
                mPrevBtn.visibility = View.VISIBLE
                mNextBtn.visibility = View.VISIBLE
            }

        }
        Picasso.get().load(mutableList[id]).resize(100,100).into(imageView)


    }

}
