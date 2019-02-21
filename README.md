# BaoRecyclerView
[简书地址](https://www.jianshu.com/p/c1090314efbf)

![实现布局](https://upload-images.jianshu.io/upload_images/1627327-646d79064e8b488c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/434/format/webp)

比如像这样的布局要求，如果用一个NestedScrollView里面嵌套多个RecyclerView，就能轻松解决，但是随着越用越久，上滑继续加载，越滑动，消耗的内存越多，而且，一进到这个界面，就开始加载全部的图片，有的用户不需要看到最底下的东西，就导致消耗流量。网速慢的情况下，下面的图片内容也在加载，抢占上面的网络资源，就会下面有的图片，比上面先出现，这样体验不好。如果你试试后台给你1000个item，下一子加载出来，小米6都会吃不消的。

因为NestedScrollView嵌套的缺点，导致我换一种写法，用一个RecyclerView，多种item，来实现这种布局，一是复用了，内存消耗就小了，然后你滑到哪里，就加载到哪，流量消耗也好一些.
