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

    var numberOfPages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener{
            numberOfPages++
            //notifies the FragmentStateAdapter that a change was made
            viewPager.adapter?.notifyItemChanged(numberOfPages-1)

            //this line will let you access fragments from the FragmentManager directly
            //supportFragmentManager.findFragmentByTag("f"+position)

            viewPager.currentItem = numberOfPages-1
        }

        //need to pass the reference to the thing that has the ViewPager2
        viewPager.adapter = object : FragmentStateAdapter(this){
            //number of fragments you want to process
            override fun getItemCount() = numberOfPages

            //returns the fragment at this "position"
            override fun createFragment(position: Int) = TextFragment.newInstance((position+1).toString())

        }
    }

}