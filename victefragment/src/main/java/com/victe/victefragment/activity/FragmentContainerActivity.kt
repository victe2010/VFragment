package com.victe.victefragment.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.victe.victefragment.R
import com.victe.victefragment.bean.BottomEntity

/**
 * Created by 13526 on 2018/1/30.
 */
open abstract class FragmentContainerActivity :FragmentActivity(){
    private var container_bottom:LinearLayout?=null;
    private var viewPager:ViewPager?=null;
    private var views:ArrayList<View> = ArrayList();
    private val fragments:ArrayList<Fragment> = ArrayList<Fragment>();
    private var adapter:MyViewPagerAdapter?=null;
    private val bottomArray:ArrayList<BottomEntity> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_layout)
        container_bottom = findViewById(R.id.container_bottom);
        viewPager = findViewById(R.id.container_viewpager);
        adapter=MyViewPagerAdapter(supportFragmentManager);
        viewPager?.adapter =adapter;
        viewPager?.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                initButton(position)
                PageSelected(position);
            }

        })
    }

    abstract fun PageSelected(position: Int);

    inner class MyViewPagerAdapter(fm: FragmentManager?):FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            return fragments.get(position)
        }

        override fun getCount(): Int {
            return fragments.size
        }

    }


    /**
     * mfragments 集合碎片
     * bottomArray 底部选项卡
     */
    fun addHomeBottom(mfragments:ArrayList<Fragment>,mbottomArray:ArrayList<BottomEntity>){
        bottomArray.clear()
        fragments.clear()
        fragments.addAll(mfragments);
        bottomArray.addAll(mbottomArray)
       for (index in bottomArray.indices){
           addChildView(index,bottomArray[index]);
       }
        adapter?.notifyDataSetChanged()
    }

    //添加底部view
    private fun addChildView(tag: Int,item:BottomEntity) {
        val view = LayoutInflater.from(this).inflate(R.layout.home_item, null)
        val tv = view.findViewById(R.id.index_home_text) as TextView
        val iv = view.findViewById(R.id.index_home_button) as ImageView
        imageViews.add(iv)
        tv.setText(item.title)
        val layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
        view.layoutParams = layoutParams
        view.id = tag
        view.setOnClickListener(onClickListener)
        container_bottom!!.addView(view)
        views.add(view);
    }
    private val imageViews:ArrayList<ImageView>  =  ArrayList();
    /**
     * 获取底部图片
     */
    protected fun getBottomImages():ArrayList<ImageView> = imageViews;

    //初始化按钮文字
    private fun initButton(_id: Int) {
        for (i in views.indices) {
//            val iv = views[i].findViewById(R.id.index_home_button) as ImageView
            val tv = views[i].findViewById(R.id.index_home_text) as TextView
            if (i == _id) {
//                Glide.with(this).load(bottomArray[_id].picSelect).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv)
                tv.setTextColor(Color.parseColor(bottomArray[_id].selectColor))
            } else {
                tv.setTextColor(Color.parseColor(bottomArray[_id].defaultColor))
//                Glide.with(this).load(bottomArray[_id].PicDefault).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv)
            }
        }
    }


    private val onClickListener = View.OnClickListener { view -> viewPager?.setCurrentItem(view.id) }




}