package com.victe.fragmentdemo

import android.app.FragmentContainer
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.victe.fragmentdemo.fragment.FindFragment
import com.victe.fragmentdemo.fragment.GameFragment
import com.victe.fragmentdemo.fragment.HomeFragment
import com.victe.fragmentdemo.fragment.PersonFragment
import com.victe.victefragment.activity.FragmentContainerActivity
import com.victe.victefragment.bean.BottomEntity

/**
 * Created by 13526 on 2018/2/1.
 */
class TestActivity: FragmentContainerActivity() {
    override fun PageSelected(position: Int) {
        Log.e("TAG","---------当前选中的下标---------->"+position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fragments = ArrayList<Fragment>();
        var entitys = ArrayList<BottomEntity>();
        fragments.add(HomeFragment.newInstance(true))
        fragments.add(FindFragment.newInstance(true))
        fragments.add(PersonFragment.newInstance(true))
        fragments.add(GameFragment.newInstance(true))
        var homeEntity = BottomEntity();
        homeEntity.title="首页"
        homeEntity.defaultColor="#ffff00";
        homeEntity.selectColor="#ff0000"
        var findEntity = BottomEntity();
        findEntity.title="发现"
        findEntity.defaultColor="#ffff00";
        findEntity.selectColor="#ff0000"
        var gameEntity = BottomEntity();
        gameEntity.title="游戏大厅"
        gameEntity.defaultColor="#ffff00";
        gameEntity.selectColor="#ff0000"
        var personEntity = BottomEntity();
        personEntity.title="我的"
        personEntity.defaultColor="#ffff00";
        personEntity.selectColor="#ff0000"
        entitys.add(homeEntity)
        entitys.add(findEntity)
        entitys.add(gameEntity)
        entitys.add(personEntity)
        addHomeBottom(fragments,entitys)
        Glide.with(this).load(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(getBottomImages().get(0))
        Glide.with(this).load(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(getBottomImages().get(1))
        Glide.with(this).load(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(getBottomImages().get(2))
        Glide.with(this).load(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(getBottomImages().get(3))

    }


}