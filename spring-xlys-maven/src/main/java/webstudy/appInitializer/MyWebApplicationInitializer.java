package webstudy.appInitializer;


import javax.servlet.ServletContext;

//MyWebApplicationInitializer是应用程序初始化器接口，所有应用程序初始化器都需要实现这个接口才能被加载到，否则就是个无效的APP初始化器
//WebApplicationInitializer是SpringWebApplicationInitializer
public interface MyWebApplicationInitializer {

	void onStartup(ServletContext servletCxt);
}