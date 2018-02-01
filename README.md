# Fragment的封装-省去重复的viewpager_fragment
## 第 1 步 在存储库的 build.gradle 中添加︰
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
## 第 2 步。添加依赖项
  	dependencies {
	     compile 'com.github.victe2010:VFragment:1.0.1'
	}
	
## 使用方式
### 1、新建一个activity继承FragmentContainerActivity
### 2、里面有个抽象方法（当前选中的fragment）
    override fun PageSelected(position: Int) {
        Log.e("TAG","---------当前选中的下标---------->"+position)
    }
### 3、新建四个碎片继承LazyFragment（懒加载模式）
     companion object {
        fun newInstance(isLazyLoad: Boolean): HomeFragment {
            val args = Bundle()
            args.putBoolean(LazyFragment.INTENT_BOOLEAN_LAZYLOAD, isLazyLoad)
            val fragment = HomeFragment()
            fragment.setArguments(args)

            return fragment
        }
    }
#### 4、在activity里面加载数据到viewpager
    addHomeBottom(fragments,entitys)
* 注意：fragments：所有碎片容器 
        entitys：底部选项配置容器
        
             var title:String?="";//默认标题
            var defaultColor:String?="";//默认颜色
            var selectColor:String?="";//选择颜色
            var PicDefault:Int?=0;//默认图片-暂时无用
            var picSelect:Int?=0;//选择图片-暂时无用
* 默认图片设置
           
            Glide.with(this).load(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(getBottomImages().get(0))
            
            ** getBottomImages返回了底部选项卡的imageview
            
            通过与PageSelected（）方法互用可以获取到当前的碎片以及修改对应选项卡的图标
            
    