package annotationstudy.controller;

import annotationstudy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {

	//@Autowired注解去IOC容器中找对应组件进行装配时规则如下：
//		0)如果不想因为IOC容器中没有符合条件的对应组件在自动装配时发生错误，可以设置@Autowired(required = false)。找不到合适的组件就不进行装配。
//		1)首先按类型找对应组件，只找到一个的话，忽略自动装配的属性名称与IOC容器组件名称相同才会进行装配的规则，也会进行自动装配。
//		2)如果按类型找组件找到不止一个的话，那么这个时候在多个可供装配的组件中按属性名与组件名称进行匹配：即指定的自动装配的属性名与
//		  组件注入IOC容器时的名称（即BeanDefinition的ClassName属性值）如果一致，将对应的组件用于自动装配。当然此时也可以用@Qualifier
//		  注解指定自动装配的属性名来与IOC容器中组件的名称进行匹配，找到对应一致的组件进行自动装配。
//		  ★★★注意★★★
//			如果使用@Qualifier注解指定自动装配的属性名称与组件名称相同则进行匹配并自动装配，那么根据@Autowired注解默认的自动装配的属性
//			名与IOC容器组件名称匹配后进行自动装配的规则将不再适用
//		3)在IOC容器中有多个可用于自动装配的组件时，还可以使用@Primary【用于注入IOC容器的组件上】来指定哪个组件最高优先级被用来装配。【注意：使用
//		  了@Primary注解，需要将@Qualifier注解去除，否则@Primary注解不生效】
//	@Qualifier("appService3")
	@Autowired(required = false)
	private AppService appService1;

	@Override
	public String toString() {
		return "AppController{" +
				"appService2=" + appService1 +
				'}';
	}
}
