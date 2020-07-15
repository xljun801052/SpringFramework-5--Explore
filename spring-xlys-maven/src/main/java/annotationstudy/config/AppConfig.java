package annotationstudy.config;

import annotationstudy.controller.AppController;
import annotationstudy.entity.Student;
import annotationstudy.service.AppService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//声明是一个配置类，相当于将AppConfig类等同于beans.xml.
//【@Configuration注解中含有@Component注解，所以配置类本身也会作为Spring中一个组件Bean】
@ComponentScan(value = "annotationstudy", includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})
}, useDefaultFilters = false)
//注解形式的包扫描，相当于加了beans.xml中的<context component-scan="...">
//但凡是加了@Controller @Service @Repository @Component四个注解的类，只要在指定扫描包下，都会被扫描作为Spring的Bean组件

//1-还可以使用excludeFilters()排除一些特定的不想被扫描的组件。
//	  配置样例：@ComponentScan(value = "annotationstudy",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
// 		通过@Filter注解实现。工作原理通过type（指定排除类型【本次以排除指定注解类型为例】）+具体type对应值（【这里表示@Controller和@Service注解的组件都不会被扫描到】）

//2-includeFilters()表示只包含指定的组件。当然需要将默认的useDefaultFilters设置为false才生效(默认为true)【defaultFilters:@Controller、@Service、@Repository、@Component】
//	  这个includeFilters()需要配合useDefaultFilters=fasle来使用，否则会不生效，还是使用默认扫那四个注解
//	  @ComponentScan(value = "annotationstudy", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})}, useDefaultFilters = false)


//3-@ComponentScans注解可以包含多个@ComponentScan，相当于@ComponentScan定制一条规则，@ComponentScans是一个规则数组
public class AppConfig {

	@Bean("student")//将方法返回值作为bean注册到Spring容器中，可以使用@Bean注解的value属性指定id
	public Student getStudent() {
		return new Student("XLYS", 25);
	}

	@Primary
	//@Bean注解的value属性指定IOC容器的beanName
	@Bean("appService2")
	public AppService getAppController2() {
		AppService appService = new AppService();
		appService.setName("label-2");
		return appService;
	}

	@Bean("appService3")
	public AppService getAppController3() {
		AppService appService = new AppService();
		appService.setName("label-3");
		return appService;
	}
}
