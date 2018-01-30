### 前言
> 从零开始，手把手带你实现一个「专注睡前的 APP」。睡觉之前如果能有一个 APP，能让我们写一写这一天的见闻或者心得，同时又能看一会段子、瞄一会好看的妹子，放松一下疲惫的身心那该多好，这也是我完成这个 APP 的原因。APP 的全部代码我已经分享到 Github 上了，需要的直接 [点击这里](https://github.com/developerHaoz/SleepHelper)，如果喜欢的话，麻烦给个 star，谢谢啦。

本文为这一系列文章的总述，如果觉得篇幅过长，请点击下面的连接

[手把手教你从零开始做一个好看的 APP - Day one](http://www.jianshu.com/p/c5b12c54c2ba)

[手把手教你从零开始做一个好看的 APP - Day two](http://www.jianshu.com/p/934a6bf274fb)

[手把手教你从零开始做一个好看的 APP - Day three](http://www.jianshu.com/p/b4fde6b835a3)

[手把手教你从零开始做一个好看的 APP - Day four](http://www.jianshu.com/p/f14fe003ffae)

[手把手教你从零开始做一个好看的 APP - Day five](http://www.jianshu.com/p/de45bc5c75e2)

在开始写正文之前，先来一波效果的展示，看看五天过后我们能实现怎样的效果
![SleepHelper](http://upload-images.jianshu.io/upload_images/4334738-acaaea47739bc4b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

本次的教程分为 5 天，内容分别为：
- Day one，准备
  - 功能需求
  - 可行性分析

- Day two，UI 及公共类的封装
  - 界面的设计及实现
  - 公共类的实现

- Day three，日记模块
  - 日记的展示
  - 悬浮菜单的实现
  - 日记增删改的实现

- Day four，妹子模块
  - 图片的获取
  - 图片的展示
  - 详情页面的展示

- Day five，段子模块
  - 段子数据的获取
  - 段子的显示

## Day one
-----
俗话说，万事开头难，在开始敲代码之前，先让我们来做一些必要的准备，这样才能事半功倍嘛！
#### 一、功能需求 
既然要做一个 APP，那我们首先还是得把 APP 的功能都列出来，有了方向才能更好的努力，因为我想做的是一个专门给睡觉前用的 APP，所以我觉得应该有以下的这些功能
- 1、日记的增删改
- 2、显示一些有趣好玩的段子
- 3、瀑布流展示漂亮的妹子
- 4、保存日记的内容以及缓存妹子图片

虽然说需求不多，但是却要运用到网络、数据存储、图片缓存、UI 设计等内容，相信整个 APP 完成下来，必定能巩固我们的 Android 基础。
#### 二、可行性分析
我们这个 APP 主要有三个模块，日记模块主要是运用到了数据库的知识，难度不大。但是，段子模块和妹子模块的数据要从哪来，这便是要好好考虑的了。幸好现在是个开源的时代，很多的数据，网上已经开源出来了。

我们先来看一下数据的内容
```
group: {
        text: "教授在河边，常常看到两只龟，缩着一动不动。有天忍不住好奇，问一农      
        民：这两只乌龟在干吗？农民说：他们在pk。教授不解地问：动都没动过p什么    
        k。老农说:他们在比谁寿命长。教授说：可是壳上有甲骨文的那只，早就死了埃
        这时，另一只猛然探出头来骂到：md，死了也不吭一声！有甲骨文的那只也伸
        出头来：“专家说啥你信啥１",

        user: {
              user_id: 4669064575,

              name: "馒头啊",

              avatar_url: "http://p3.pstatp.com/medium/6237/7969345239",
},

          content: "教授在河边，常常看到两只龟，缩着一动不动。有天忍不住好奇，问        
           一农民：这两只乌龟在干吗？农民说：他们在pk。教授不解地问：动都没动过
           p什么k。老农说:他们在比谁寿命长。教授说：可是壳上有甲骨文的那只，早
           就死了埃这时，另一只猛然探出头来骂到：md，死了也不吭一声！有甲骨文
           的那只也伸出头来：“专家说啥你信啥１",
...  
}
```
```
{
          id: "56cc6d1d421aa95caa7076df",

          type: "福利",

          url: "http://ww1.sinaimg.cn/large/7a8aed7bgw1esxxi1vbq0j20qo0hstcu.jpg",

          used: true,

          who: "张涵宇"

}
```
上面那两段代码分别是段子和妹子模块的 json 类型的数据，我已经将一些没用的字段去掉了。剩下的都是我们想要的数据。可以看到段子数据中，有着段子的内容，以及发布者的头像和名字。而妹子数据中有着图片的 url、id、以及图片的类型。相信有了这么丰富的数据，我们想要完成这个 APP 也是有底气了。


## Day two
-----
#### 一、界面的设计及实现
既然我们想要完成一个好看的 APP，那么好看的界面便是必不可少的，这里我强烈推荐 APP 界面的设计必须尽量遵从 Google 提出的 [Material Design](http://wiki.jikexueyuan.com/project/material-design/material-design-intro/introduction.html)，在这个推荐一个能够让我们实现 Material Design 变得更加简单的网站  [material design palette](https://www.materialpalette.com/light-blue/light-blue)，我这个 APP 的配色就是用这个网站完成的，贴几张图片，让你感受一下它的强大

![material design palette](http://upload-images.jianshu.io/upload_images/4334738-d4a209808204270e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Material Design 风格的图标](http://upload-images.jianshu.io/upload_images/4334738-f1a1e9f2847deb06.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

借助这个网站便能让我们完成 APP 的配色以及图标的收集，为下一步功能的实现，先打好了基础，至于界面的设计就仁者见仁智者见智了，篇幅有限，我就不多讲了。

APP 的最终设计效果如下：
![SleepHelper](http://upload-images.jianshu.io/upload_images/4334738-acaaea47739bc4b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


#### 二、公共类的实现
因为这个项目有三个模块，有一些东西其实是可以通用的，如果我们先把这些能够通用的东西，封装起来，供给所有的模块调用的话，相信会大大提高我们的开发效率。
##### 1、网络工具类的封装
这个 APP 中，很多地方都要用到网络请求，因此也就很有必要将网络请求封装起来，因为这个 APP 的规模比较小，因此我选择了 Volley 这个网络框架作为我们网络请求库，把网络请求封装起来，哪个地方需要，调用一下就行了。对于网络请求，我觉得每个程序员都该懂点 HTTP，这里附上一篇有关 HTTP 的文章 [程序员都该懂点 HTTP](http://www.jianshu.com/p/d86b66672ef4)。

先让我们来写个将网络请求进行回调的接口
```
public interface VolleyResponseCallback {
    void onSuccess(String response);
    void onError(VolleyError error);
}
```

然后将网络请求封装起来
```
public class VolleyHelper {

    /**
     * 用于发送 Get 请求的封装方法
     *
     * @param context Activity 的实例
     * @param url 请求的地址
     * @param callback 用于网络回调的接口
     */
    public static void sendHttpGet(Context context, String url, final VolleyResponseCallback callback){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                callback.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error);
            }
        });
        requestQueue.add(stringRequest);
    }


}
```
##### 2、Json 解析的帮助类
因为我们这个 APP 中，获取到的数据都是 Json 格式的，因此也就有必要将有关的 Json 解析封装成一个工具类，传入一个 String 类型的数据，直接得到数据实体类的 List。
```
public class CommonParser {

    /**
     * 用来解析列表性的JSON数据
     * 如:
     * {"success":true,"fileList":[{"filename":"文件名1","fileSize":"文件大小1"},
     * {"filename":"文件名2","fileSize":"文件大小2"}]}
     *
     * @param result     网络返回来的JSON数据   比如:上面的整串数据
     * @param successKey 判断网络是否成功的字段  比如:上面的success字段
     * @param arrKey     列表的字段            比如:上面的fileList字段
     * @param clazz      需要解析成的Bean类型
     * @param <T>        需要解析成的Bean类型
     * @return
     */
    public static <T> List<T> parseForList(String result, String successKey, String arrKey, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        JSONObject rootJsonObject = null;
        try {
            rootJsonObject = new JSONObject(result);
            if (rootJsonObject.getBoolean(successKey)) {
                JSONArray rootJsonArray = rootJsonObject.getJSONArray(arrKey);
                Gson g = new Gson();
                for (int i = 0; i < rootJsonArray.length(); i++) {
                    T t = g.fromJson(rootJsonArray.getJSONObject(i).toString(), clazz);
                    list.add(t);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
```
##### 3、HomeActivity（主页面）的封装
主页面我用的是 TabLayout + ViewPager + Fragment，也是现在主流 APP 主页面的显示方式。主界面底部是我们三个模块的图标和名称，通过左右滑动能实现界面的跳转。
###### 底部图标的实体类 CommonTabBean 
```
public class CommonTabBean implements CustomTabEntity{

    private int selectedIcon;
    private int unselectedIcon;
    private String title;

    public CommonTabBean(String title){
        this.title = title;
    }

    public CommonTabBean(String title, int selectedIcon, int unselectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unselectedIcon = unselectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectedIcon;
    }
}
```

###### ViewPager + Fragment 通用的 Adapter
```
public class CommonPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public CommonPagerAdapter(FragmentManager fragmentManager, List<Fragment> mFragments){
        super(fragmentManager);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
```

## Day three
-----
关于日记模块的实现，其实我是复用了以前写过的一个[日记 APP](https://github.com/developerHaoz/WatermelonDiaryNew)，具体的思路和做法，可以参考我的这篇文章 [Android 一款十分简洁、优雅的日记 APP](http://www.jianshu.com/p/b4fde6b835a3)

## Day four
-----
#### 一、图片的获取
##### 1、根据返回的数据来编写图片的实体类
```
public class MeiziBean {

    @SerializedName("_id")
    private String id;
    @SerializedName("url")
    private String imageUrl;
    @SerializedName("who")
    private String who;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public MeiziBean(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
```
##### 2、图片的展示
可以看到我是用瀑布流的方式来实现图片的展示，效果还不错，但其实实现起来也是很简单的

先写个图片的布局作为 RecyclerView 的 Item
```
<android.support.v7.widget.CardView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

                <ImageView
                    android:id="@+id/item_iv_meizi"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_centerHorizontal="true"
                    android:layout_centerVertical="true"
                    />
</android.support.v7.widget.CardView>
```
可以看到我在 ImageView 的外面加了一个 CardView，这个一种卡片式布局，能让图片看起来就像一张卡片一样，相当的优雅、美观。

接着编写 Adapter，将数据和界面进行绑定
```
public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.MeiziViewHolder> {

    private List<MeiziBean> mMeiziBeanList;
    private Fragment mFragment;

    public MeiziAdapter(List<MeiziBean> mMeiziBeanList, Fragment mFragment){
        this.mMeiziBeanList = mMeiziBeanList;
        this.mFragment = mFragment;
    }

    @Override
    public MeiziViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meizi, null);
        return new MeiziViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeiziViewHolder holder, final int position) {

        Glide.with(mFragment)
                .load(mMeiziBeanList.get(position).getImageUrl())
                .fitCenter()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mIvMeizi);

        holder.mIvMeizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> resultList = new ArrayList<String>();
                for (MeiziBean meiziBean : mMeiziBeanList) {
                    resultList.add(meiziBean.getImageUrl());
                }
                DetailActivity.startActivity(mFragment.getActivity(), resultList, position);

            }
        });

    }

    @Override
    public int getItemCount() {
        if(mMeiziBeanList.size() > 0){
            return mMeiziBeanList.size();
        }
        return 0;
    }

    public static class MeiziViewHolder extends RecyclerView.ViewHolder{

        ImageView mIvMeizi;

        public MeiziViewHolder(View itemView) {
            super(itemView);
            mIvMeizi = (ImageView) itemView.findViewById(R.id.item_iv_meizi);
        }
    }
}
```
最后在 Fragment 进行数据的获取，以及布局的初始化就行了
```
public class MeiziFragment extends Fragment {

    ......

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meizi, container, false);
        ButterKnife.bind(this, view);
        initView();
        refreshMeizi();
        return view;
    }

    /**
     * 刷新当前界面
     */
    private void refreshMeizi() {
        mRefresh.setColorSchemeResources(R.color.colorPrimary);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                mRefresh.setRefreshing(false);
            }
        });
    }

    private void initView() {
        VolleyHelper.sendHttpGet(getActivity(), MeiziApi.getMeiziApi(), new VolleyResponseCallback() {
            @Override
            public void onSuccess(String s) {
                response = s;
                meiziBeanList = GsonHelper.getMeiziBean(response);
                mRvShowMeizi.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                Collections.shuffle(meiziBeanList);
                mRvShowMeizi.setAdapter(new MeiziAdapter(meiziBeanList, MeiziFragment.this));
            }

            @Override
            public void onError(VolleyError error) {
                Logger.d(error);
            }
        });
    }

```

##### 3、详情页面的展示
干巴巴的，整个模块只能显示妹子的图片怎么行呢！！！怎么着也得能查看大图，根据手势放大缩小，以及浏览下一张图片才行嘛，说干就干。

因为图片需要有根据手势来放大缩小的功能，因此我便想到了 [PhotoView](https://github.com/chrisbanes/PhotoView)，这是网上一个大神写的，继承自 ImageView 的一个自定义控件。图片加载我用的是
 Glide，如果没了解过这个库的，强烈推荐，一行代码就能搞定图片加载，你确定不研究一下。这里附上一篇有关 Glide 的文章 [Glide 一个强大的图片加载框架](http://www.jianshu.com/p/fae51d781987)

```
public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(String imageUrl) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IMAGE_URL, imageUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String imageUrl = bundle.getString(IMAGE_URL);
        Glide.with(this).load(imageUrl).into(mPvShowPhoto);
        mPvShowPhoto.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float v, float v1) {
                getActivity().finish();
            }

            @Override
            public void onOutsidePhotoTap() {

            }
        });
        return view;
    }
}
```

## Day five
-----
#### 一、段子数据的获取
段子数据的获取其实跟妹子模块的方法基本一样

先编写实体类
```
public class DuanziBean {

    @SerializedName("group")
    private GroupBean groupBean;
    private String type;

    public GroupBean getGroupBean() {
        return groupBean;
    }

    public void setGroupBean(GroupBean groupBean) {
        this.groupBean = groupBean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
```
```
public class GroupBean {

    private String text;
    private long id;
    private UserBean user;

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public UserBean getUser() {
        return user;
    }

    public static class UserBean {

        private long user_id;
        private String name;
        private String avatar_url;

        public String getName() {
            return name;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

    }
}
```
写好实体类之后，使用我们之前已经封装好的网络请求工具以及解析工具，便能将返回的数据，解析成一个包含段子实体类的 List。
#### 二、段子的显示
老规矩，先写个 RecyclerView 的 Item
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical"
    >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:paddingLeft="8dp"
        >

        <de.hdodenhof.circleimageview.CircleImageView
            android:id="@+id/duanzi_civ_avatar"
            android:layout_width="24dp"
            android:layout_height="24dp"
            android:src="@drawable/avatar"
            android:layout_gravity="center"
            />

        <TextView
            android:id="@+id/duanzi_tv_author"
            android:paddingLeft="8dp"
            android:paddingStart="8dp"
            android:layout_width="match_parent"
            android:layout_height="16dp"
            android:text="DeveloperHaoz"
            android:layout_gravity="center_vertical"
            />

    </LinearLayout>

    <TextView
        android:id="@+id/duanzi_tv_content"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingBottom="10dp"
        android:paddingLeft="40dp"
        android:paddingRight="10dp"
        android:text=""
        />
    <include layout="@layout/layout_app_divide"/>

</LinearLayout>
```
然后编写将数据和界面进行绑定的 Adapter
```
public class DuanziAdapter extends RecyclerView.Adapter<DuanziAdapter.DuanziViewHolder>{

    private Fragment mFragment;
    private List<DuanziBean> mDuanziBeanList;

    public DuanziAdapter(Fragment fragment, List<DuanziBean> duanziBeanList){
        this.mFragment = fragment;
        this.mDuanziBeanList = duanziBeanList;
    }

    @Override
    public DuanziViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_duanzi, null);
        return new DuanziViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DuanziViewHolder holder, int position) {
        try {
            DuanziBean duanziBean = mDuanziBeanList.get(position);
            Glide.with(mFragment).load(duanziBean.getGroupBean().getUser().getAvatar_url()).into(holder.mCivAvatar);
            holder.mTvContent.setText(duanziBean.getGroupBean().getText());
            holder.mTvAuthor.setText(duanziBean.getGroupBean().getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mDuanziBeanList.size();
    }

    public static class DuanziViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mCivAvatar;
        private TextView mTvAuthor;
        private TextView mTvContent;

        public DuanziViewHolder(View itemView) {
            super(itemView);
            mCivAvatar = (CircleImageView) itemView.findViewById(R.id.duanzi_civ_avatar);
            mTvAuthor = (TextView) itemView.findViewById(R.id.duanzi_tv_author);
            mTvContent = (TextView) itemView.findViewById(R.id.duanzi_tv_content);
        }
    }


}
```
最后段子页面中进行数据和获取以及界面的初始化
```
public class DuanziFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_duanzi, container, false);
        ButterKnife.bind(this, view);
        initView();
        initRefresh();
        return view;
    }

    private void initRefresh() {
        mRefresh.setColorSchemeResources(R.color.colorPrimary);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                mRefresh.setRefreshing(false);
            }
        });
    }

    private void initView() {
        VolleyHelper.sendHttpGet(getActivity(), DuanziApi.GET_DUANZI, new VolleyResponseCallback() {
            @Override
            public void onSuccess(String response) {
                List<DuanziBean> mDuanziBeanList = GsonHelper.getDuanziBeanList(response);
                mDuanziBeanList.remove(3);
                mRvShowDuanzi.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRvShowDuanzi.setAdapter(new DuanziAdapter(DuanziFragment.this, mDuanziBeanList));
            }

            @Override
            public void onError(VolleyError error) {
                Logger.d(error);
            }
        });
    }

}
```

以上便是本文的全部内容，这个 APP 的全部代码我已经分享到  [Github](https://github.com/developerHaoz/SleepHelper) 上了，如果觉得对你有帮助的话，就赏个 star 吧。

-----
### 猜你喜欢
- [Android 一款十分简洁、优雅的日记 APP](http://www.jianshu.com/p/b4fde6b835a3)
- [Android 能让你少走弯路的干货整理](http://www.jianshu.com/p/514656c383a2)
- [Android 撸起袖子，自己封装 DialogFragment](http://www.jianshu.com/p/c9f20ec7277a)
