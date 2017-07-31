
# StateLayout

--高自由度，使用简洁

--是一个把空布局 错误布局 加载布局 内容布局整合成一个View的布局

--仅提供的是思路，封装什么动画，根据自己项目，在show方法添加启动动画，或移除动画

--[简书地址 ]（http://www.jianshu.com/p/d2c12a3996d4?utm_campaign=maleskine&utm_content=note&utm_medium=reader_share&utm_source=qzone）

<img src="https://github.com/While1true/StateLayout/blob/master/device-2017-07-31-072242.png" width=200 height=355 /><img src="https://github.com/While1true/StateLayout/blob/master/device-2017-07-31-072253.png" width=200 height=355 /><img src="https://github.com/While1true/StateLayout/blob/master/device-2017-07-31-072305.png" width=200 height=355 /><img src="https://github.com/While1true/StateLayout/blob/master/device-2017-07-31-072328.png" width=200 height=355 />


-遇到的坑 
```
//这个方法返回的不是填充的View，而是父View
inflater.inflate(contentres, this, true)
```
##//第一步app中初始化 设置全局的状态布局（一般图片文字会改，整体风格一致）
```
      StateLayout.init(new StateLayout.Builder()
                .setEmptyRes(R.layout.empty)
                .setErrorRes(R.layout.error)
                .setLoadingRes(R.layout.loading)
                .build()
        );
```



##第二部 在onCreat中 把content布局 包装到StateLayout
```
 stateLayout = new StateLayout(this).setContent(R.layout.content);
 setContentView(stateLayout);



//使用（支持更改文字，图片，按钮颜色，通过遍历布局中的第一个来设置，不使用id，简洁）
       switch (i) {
                case 0:
                    stateLayout.showLoading();
                    break;
                case 1:
                    stateLayout.showEmpty("kong","sssss" ,R.mipmap.ic_launcher_round,new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "dd", 0).show();
                        }
                    });
                    break;
                case 2:
                    stateLayout.showContent();
                    break;
                case 3:
                    stateLayout.showError("cuwoeo", "sss:",R.mipmap.ic_launcher, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "dzzd", 0).show();
                        }
                    });
                    break;

            }
```
```
//布局示例
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical" android:layout_width="match_parent"
    android:gravity="center_vertical"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="空布局" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:srcCompat="@android:drawable/alert_light_frame" />

</LinearLayout>
```

//通过遍历第一个TextView 第一个ImageView 第一个Button来更改文字，图片，设置监听，而不用findviewbyid  
//使用变简洁 自由度些许下降，但一般状态布局是很简单的，基本不影响
```
public ImageView getImageView(View view) {
        if (view instanceof ImageView) {
            return (ImageView) view;
        } else if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                ImageView imageView = getImageView(((ViewGroup) view).getChildAt(i));
                if (imageView != null)
                    return imageView;
            }
        }
        return null;
    }
```

![device-2017-07-31-080201.png](http://upload-images.jianshu.io/upload_images/6456519-8c83fba610d4aa49.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/200)![device-2017-07-31-072242.png](http://upload-images.jianshu.io/upload_images/6456519-4790063669d34feb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/200)

##--

[轻松一刻 ：歌曲地址]（https://changba.com/wap/index.php?s=WU11nfpa8slaJiQokIGdUQ）

##-Ong
