package webstudy;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloSpringWeb {

	public static void main(String[] args) throws LifecycleException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		/**
		 * test：spring容器创建成功
		 * */
		//目前启动容器最少依赖的包：jcl日志包、aop包、core包、bean包、context包，为什么和大家说的只引用context包不一样？
		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
		//	System.out.println(beanDefinitionName);
		//org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		//org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		//org.springframework.context.annotation.internalCommonAnnotationProcessor
		//org.springframework.context.event.internalEventListenerProcessor
		//org.springframework.context.event.internalEventListenerFactory

		/**
		 * test：创建Tomcat容器，启动项目
		 * */
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(80);
		//添加项目相关信息到tomcat
		Context context = tomcat.addContext("/", HelloSpringWeb.class.getResource("/").getPath().replaceAll("%20",""));
		context.addLifecycleListener((LifecycleListener)Class.forName((tomcat.getHost().getConfigClass())).newInstance());
		tomcat.start();
		System.out.println("tomcat启动完成！");
		tomcat.getServer().await();
	}

}


