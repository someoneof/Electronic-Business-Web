# Electronic-Business-Web
this is a 电商网站

本网站使用struts2+hibernate3.x+spring3.x框架编写.
uml:PageViewBase->Myaction->ActionSupport

PageViewBase中封装了与分页有关的代码,所以只需要继承PageViewBase,重写getWherehql和getQueryResult函数即可.
每添加一个模块,继承PageViewBase将jsp页面的数据封装到该formbean中,再编写Action即可.

另外Myaction实现了图片添加的功能,如果要添加图片,只需要在继承自PageViewBase的formbean中实现AddImage接口,重写关于图片存放路径的函数即可
