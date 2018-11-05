ssm数据校验和数据回显

数据校验

校验的理解

  项目中，通常使用较多是前端的校验，比如页面中js校验。对于安全要求较高点建议在服务端进行校验。

  服务端校验：
	
  控制层conroller：校验页面请求的参数的合法性。在服务端控制层conroller校验，不区分客户端类型（浏览器、手机客户端、远程调用）
	
  业务层service（使用较多）：主要校验关键业务参数，仅限于service接口中使用的参数。
	
  持久层dao：一般是不校验的。
  
springmvc校验需求
  
  springmvc使用hibernate的校验框架validation(和hibernate没有任何关系)。

  校验思路：
	页面提交请求的参数，请求到controller方法中，使用validation进行校验。如果校验出错，将错误信息展示到页面。

  本项目介绍的具体需求：
	商品修改，添加校验（校验商品名称长度，生产日期的非空校验），如果校验出错，在商品修改页面显示错误信息。
  
  
数据回显

什么数据回显：
提交后，如果出现错误，将刚才提交的数据回显到刚才的提交页面。

pojo数据回显方法

1.springmvc默认对pojo数据进行回显。
pojo数据传入controller方法后，springmvc自动将pojo数据放到request域，key等于pojo类型（首字母小写）
使用@ModelAttribute指定pojo回显到页面在request中的key

2.@ModelAttribute还可以将方法的返回值传到页面
在商品查询列表页面，通过商品类型查询商品信息。
在controller中定义商品类型查询方法，最终将商品类型传到页面。

3.使用最简单方法使用model，可以不用@ModelAttribute。

具体的解释过程课参考博主的csdn博客相关文章https://blog.csdn.net/qq_38931949/article/details/83746723

