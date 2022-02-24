package edu.temple.imageactivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainAct : AppCompatActivity(), ImageAdapter.ImageOperations {
    lateinit var foodName: TextView
    lateinit var foodImg: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        foodName = findViewById(R.id.names)
        foodImg = findViewById(R.id.food_img)
        recyclerView.layoutManager =  GridLayoutManager(this, 4)//creates grid for recycler
        //creating a list of images and names
        val imgList = listOf<Int>(R.drawable.blueberries, R.drawable.burger, R.drawable.cake, R.drawable.frenchfries, R.drawable.grcheese, R.drawable.hotdog, R.drawable.mashed_potatos, R.drawable.pasta,
            R.drawable.ribs, R.drawable.sandwich, R.drawable.soup, R.drawable.taco)//drawables for the images

        val dogNames = listOf<String>("blueberries", "burger", "cake", "frenchfries", "grilled cheese", "hotdog", "mashed potatos",
            "pasta", "ribs", "sandwich", "soup", "taco")
        recyclerView.adapter = ImageAdapter(this, imgList, dogNames, this)
//recyclerview setup and passes the images
    }

    override fun onImageClicked(name: String, img: Int) {
        //when image is clicked in recyclerview set image and name
        foodName.text = name;
        foodImg.setImageResource(img)
    }
}