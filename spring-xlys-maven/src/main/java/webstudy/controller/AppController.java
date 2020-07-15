package webstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController这个组合注解（ composed annotation）就是：@Controller+@ResponseBody
@RestController
@RequestMapping("/app")
public class AppController {

//	1-SpringMVC分发请求流程：
//		①在Spring容器初始化时扫描所有加了@Controller注解【或者与@Controller主要功能相同的注解】的类，并创建一个Map集合【此种情况下，SpringMVC请求分发路径中的Map
//		在RequestMappingHandlerMapping类中定义】
//		②遍历第一步中类里面所有的方法，寻找加了@RequestMapping注解【或者与@RequestMapping主要功能相同的注解】的方法，
//		把@RequestMapping注解的值作为Map的key,把对应的方法对象作为Map的value存入Map.
//		③根据用户请求的URI【非URL】来作为key去查Map,查到的化返回Method方法对象，否则返回找不到，通常是404
//		④根据反射，调用对应的method

//	2-实现@Controller还有其他方式：效果等同于@Controller,将声明类作为一个Controller组件。【此种情况下，SpringMVC请求分发路径中的Map
//			在BeanNameUrlHandlerMapping类中定义，拦截请求规则是通过@Component注解的value值来匹配URI】
//		①实现Controller接口
//		②实现HttpRequestHandler接口

//	3-@Component注解是将当前类声明未Spring-Bean，而非普通Bean,并注册到Spring容器中去。

	@GetMapping("info")
	public String getAppInfo() {
		return "name:app1;cost:100W";//name:app1;cost:100W
	}
}
