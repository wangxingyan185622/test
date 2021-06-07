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
 * @Controller������
 * 1.��ʾ��ǰ������controller��
 * 2.����ǰ��Ķ���Ĵ�������spring��������
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gzcc.pojo.User;

@Controller
public class HelloController {
	
	/* �Զ�������ת����ʽ   @InitBinder��ʼ�����ڸ�ʽ  ��˷���·����testDate?date=2021-3-30 9:40:20 */
	//�������ֻ��֧������ġ�-����ʽ�����ڣ�������ʵ���testDate?date=2021/3/30 9:40:20�ᱨ��
	@InitBinder
	public void InitBinder2 (ServletRequestDataBinder binder){
		binder.registerCustomEditor(java.util.Date.class, 
			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
		);
	}

	
	
	
	
	//����·����localhost/day01-springmvc/hello
	@RequestMapping("hello")
	public String toHello(){
		System.out.println("hello springmvc!");
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/**
//	 * ��ϰ2��ͨ�����������/param1,����url����ƴ�Ӳ���name��age���͸�������
//	 * /param1?name=zhangsan&age=20
//	 */
//	@RequestMapping("/param1")
//	public String param1(String name,Integer age){
//		System.out.println("name:"+name);
//		System.out.println("age:"+age);
//		return "home";
//	}
//	/**
//	 * ��ϰ3��ͨ�����������/param2
//	 * path:/param2?name=lilei&age=20&addr=beijing
//	 */
//	@RequestMapping("/param2")
//	public String param2(User user){
//		System.out.println(user);
//		return "home";
//	}
//	
//	/**
//	 * ��ϰ4:springmvc���������͵Ĳ���
//	 * /testDate?date=2021-3-30 9:40:20
//	 * /testDate?date=2021/3/30 9:40:20
//	 * 
//	 * ��springmvcĬ�Ͻ��յ��������Ͳ�������ʽΪ��
//	 * ��/��/�գ���/���ָ����������������ݹ��������ڸ�ʽ����/�ָ��ģ��ͻ����400����
//	 * ���Խ�springmvc��Ĭ�ϵ�����ʱ���ʽ��Ϊ�ԡ�-���ָ��ĸ�ʽ����Ҫ���������Զ�������
//	 * ��ʽת����
//	 */
//	@RequestMapping("testDate")
//	public  String testDate(Date date){
//		System.out.println(date.toLocaleString());
//		return "home";
//	}
//	
//	/**
//	 * 5.��������ת��
//	 * testForward---ת����--->/hello
//	 * springmvc�У�return ��jsp�����֡���Ĭ�Ͼ���ת����ָ����Jsp,
//	 * Ҳ������ʾ��ͨ����·����ǰ�����"forward:/hello(·����" ʵ��ת��
//	 */
//	@RequestMapping("testForward")
//	public String testForward(){
//		System.out.println("testForward");//testForward(�˷�����ӡ�ģ� hello springmvc!�������hello������ӡ�ģ�
//		return "forward:/hello";  //��ʹ��forwardȥת������һ����������hello����ķ�����
//	}
//	
//	/**
//	 * 6.�ض���
//	 * 	/testRedirect--�ض���--->/hello
//	 * ����ǰ��·���ᷢ���仯�����Ϊhello
//	 * ��Ҫ�ض����·����ǰ�����   "redirect:/·��" ��ʵ��
//	 */
//	@RequestMapping("testRedirect")
//	public String testRedirect(){
//		System.out.println("testRedirect");
//		return "redirect:/hello";
//	}
//	
//	/**
//	 * 7.����post�ύ����������
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
//	 * 8.���ԣ�ͨ��Model+ת�������ݵ�jsp
//	 */
//	@RequestMapping("testModel")
//	public String testModel(Model model){
////		ModelAndView mv=new ModelAndView();
////		mv.setViewName("test");
////		mv.addObject("name","�����");
////		mv.addObject("age","50");
//		
//		List list=new ArrayList();
//		list.add("����");
//		list.add("����");
//		list.add("����");
//		model.addAttribute("list", list);
//		
//	
////		model.addAttribute("name", "������");
////		model.addAttribute("age",40);
//		return "test";
//		
//	}
//	/**
//	 * 9.�������������Ӧjson����
//	 * ��1����һ��User������json��ʽ��Ӧ�������
//	 * ��2�������User������json��ʽ��Ӧ�������
//	 */
//	
//	@RequestMapping("testJson")
//	@ResponseBody  //��ע������õײ�Ὣ����תΪjson��ʽ
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
