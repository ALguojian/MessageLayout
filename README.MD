# 个人信息栏：

最新版本如下：

[![](https://jitpack.io/v/ALguojian/MessageLayout.svg)](https://jitpack.io/#ALguojian/MessageLayout)

1.Add it in your root build.gradle at the end of repositories:

```
allprojects {
        repositories {
            ...
        maven { url 'https://jitpack.io' }
        }
    }
```

2. Add the dependency
```
dependencies {
        implementation 'com.github.ALguojian:MessageLayout:1.0.0'
    }
```

```
 <com.alguojian.mylibrary.MessageLayout
        android:id="@+id/messageLayout"
        android:layout_width="match_parent"
        android:layout_height="120dp"
        android:background="#ffffff"
        app:centerTextString="首席设计师"
        app:leftTextMarginLeft="10dp"
        app:leftTextSize="16sp"
        app:leftTextString="头衔"
        app:rightIconShow="true" />
```