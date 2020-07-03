package webstudy.appInitializer.impl;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import webstudy.appInitializer.MyWebApplicationInitializer;
import webstudy.config.AppConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

//这个就是真正的应用程序初始化器--->用来初始化spring容器
public class MyWebApplicationInitializer1 implements MyWebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt) {
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		//加载配置类AppConfig
		ac.register(AppConfig.class);
		ac.refresh();

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
}
