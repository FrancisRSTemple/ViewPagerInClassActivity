package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private val addButton: Button by lazy {
        findViewById(R.id.addFragmentButton)
    }

    private val viewPager: ViewPager2 by lazy {
        findViewById(R.id.activityViewPager)
    }

    var numberOfPAges = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener{
            numberOfPAges++
        }

        //need to pass the reference to the thing that has the ViewPager2
        viewPager.adapter = object : FragmentStateAdapter(this){
            //number of fragments you want to process
            override fun getItemCount() = numberOfPAges

            //returns the fragment at this "position"
            override fun createFragment(position: Int) = TextFragment.newInstance((position+1).toString())

        }
    }

}