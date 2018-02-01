package com.victe.fragmentdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import com.victe.fragmentdemo.fragment.FindFragment
import com.victe.fragmentdemo.fragment.GameFragment
import com.victe.fragmentdemo.fragment.HomeFragment
import com.victe.fragmentdemo.fragment.PersonFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var list = ArrayList<Fragment>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.add(HomeFragment.newInstance(true))
        list.add(GameFragment.newInstance(true))
        list.add(FindFragment.newInstance(true))
        list.add(PersonFragment.newInstance(true))
        viewPager.adapter = Myadapter()
    }
    inner class Myadapter:FragmentStatePagerAdapter(supportFragmentManager){
        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}
