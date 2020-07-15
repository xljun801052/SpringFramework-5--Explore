package annotationstudy;

import annotationstudy.config.AppConfig;
import annotationstudy.controller.AppController;
import annotationstudy.entity.Student;
import annotationstudy.service.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(ac.getBean(Student.class));//Student{name='XLYS', age=25}
		for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
			System.out.println("beanDefinitionName = " + beanDefinitionName);
			/*这五个是Spring本身Bean组件*/
//			beanDefinitionName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//			beanDefinitionName = org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//			beanDefinitionName = org.springframework.context.annotation.internalCommonAnnotationProcessor
//			beanDefinitionName = org.springframework.context.event.internalEventListenerProcessor
//			beanDefinitionName = org.springframework.context.event.internalEventListenerFactory
			/*这五个是我们添加的Bean组件*/
//			beanDefinitionName = appConfig
//			beanDefinitionName = appController
//			beanDefinitionName = appMapper
//			beanDefinitionName = appService
//			beanDefinitionName = student
		}
		System.out.println("==========容器中有几个AppService,beanName是？==================");
		String[] beanNamesForType = ac.getBeanNamesForType(AppService.class);
		for (String s : beanNamesForType) {
			System.out.println("beanName = " + s);
		}
		System.out.println("==========@Autowired自动装配的和那个注入进去的是否是同一个AppService？==================");
//		System.out.println(ac.getBean(AppService.class));
		System.out.println(ac.getBeansOfType(AppService.class));
		System.out.println(ac.getBean(AppController.class));
		//得出结论：是同一个，因为内存地址相同
//		annotationstudy.service.AppService@143640d5
//		AppController{appService=annotationstudy.service.AppService@143640d5}
	}
}
