package com.gzcc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
/**
 * @Controller的作用
 * 1.表示当前类属于controller层
 * 2.将当前类的对象的创建交给spring容器管理
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gzcc.pojo.User;

@Controller
public class HelloController {
	
	/* 自定义日期转换格式   @InitBinder初始化日期格式  因此访问路径：testDate?date=2021-3-30 9:40:20 */
	//这个方法只能支持上面的“-”形式的日期，如果访问的是testDate?date=2021/3/30 9:40:20会报错
	@InitBinder
	public void InitBinder2 (ServletRequestDataBinder binder){
		binder.registerCustomEditor(java.util.Date.class, 
			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
		);
	}

	
	
	
	
	//请求路径：localhost/day01-springmvc/hello
	@RequestMapping("hello")
	public String toHello(){
		System.out.println("hello springmvc!");
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/**
//	 * 练习2：通过浏览器访问/param1,并在url后面拼接参数name和age发送给服务器
//	 * /param1?name=zhangsan&age=20
//	 */
//	@RequestMapping("/param1")
//	public String param1(String name,Integer age){
//		System.out.println("name:"+name);
//		System.out.println("age:"+age);
//		return "home";
//	}
//	/**
//	 * 练习3：通过浏览器访问/param2
//	 * path:/param2?name=lilei&age=20&addr=beijing
//	 */
//	@RequestMapping("/param2")
//	public String param2(User user){
//		System.out.println(user);
//		return "home";
//	}
//	
//	/**
//	 * 练习4:springmvc绑定日期类型的参数
//	 * /testDate?date=2021-3-30 9:40:20
//	 * /testDate?date=2021/3/30 9:40:20
//	 * 
//	 * 在springmvc默认接收的日期类型参数，格式为：
//	 * 年/月/日（用/来分隔），如果浏览器传递过来的日期格式不是/分隔的，就会出现400错误；
//	 * 可以将springmvc中默认的日期时间格式改为以“-”分隔的格式，需要添加上面的自定义日期
//	 * 格式转换器
//	 */
//	@RequestMapping("testDate")
//	public  String testDate(Date date){
//		System.out.println(date.toLocaleString());
//		return "home";
//	}
//	
//	/**
//	 * 5.测试请求转发
//	 * testForward---转发到--->/hello
//	 * springmvc中，return “jsp的名字”，默认就是转发到指定的Jsp,
//	 * 也可以显示的通过在路径的前面加上"forward:/hello(路径）" 实现转发
//	 */
//	@RequestMapping("testForward")
//	public String testForward(){
//		System.out.println("testForward");//testForward(此方法打印的） hello springmvc!（上面的hello方法打印的）
//		return "forward:/hello";  //会使用forward去转发到另一个方法，如hello上面的方法上
//	}
//	
//	/**
//	 * 6.重定向
//	 * 	/testRedirect--重定向--->/hello
//	 * 访问前后路径会发生变化，会变为hello
//	 * 在要重定向的路径的前面加上   "redirect:/路径" 来实现
//	 */
//	@RequestMapping("testRedirect")
//	public String testRedirect(){
//		System.out.println("testRedirect");
//		return "redirect:/hello";
//	}
//	
//	/**
//	 * 7.测试post提交的乱码问题
//	 */
//	@RequestMapping("testPost")
//	public String testPost(String username,String pwd){
//		
//		System.out.println("username:"+username);
//		System.out.println("password:"+pwd);
//		return "home";
//	}
//	
//	/**
//	 * 8.测试：通过Model+转发带数据到jsp
//	 */
//	@RequestMapping("testModel")
//	public String testModel(Model model){
////		ModelAndView mv=new ModelAndView();
////		mv.setViewName("test");
////		mv.addObject("name","李冰冰");
////		mv.addObject("age","50");
//		
//		List list=new ArrayList();
//		list.add("张三");
//		list.add("李四");
//		list.add("王五");
//		model.addAttribute("list", list);
//		
//	
////		model.addAttribute("name", "范冰冰");
////		model.addAttribute("age",40);
//		return "test";
//		
//	}
//	/**
//	 * 9.测试项浏览器响应json数据
//	 * （1）将一个User对象以json格式响应给浏览器
//	 * （2）将多个User对象以json格式响应给浏览器
//	 */
//	
//	@RequestMapping("testJson")
//	@ResponseBody  //此注解的作用底层会将数据转为json格式
//	public List<User> testJdon(){
//		List<User> list = new ArrayList();
//
//		
//		list.add(new User("zh",20));
//		list.add(new User("li",20));
//		list.add(new User("ww",20));
//		list.add(new User("xx",20));
//		
//		
//		return list;
//	}
	
	
}
