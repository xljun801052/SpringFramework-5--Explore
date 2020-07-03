package webstudy.servletContainerInterface;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.WebApplicationInitializer;
import webstudy.appInitializer.MyWebApplicationInitializer;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//原理：实现servlet3.0规范：实现ServletContainerInitializer这个Web容器初始化器，承载web容器的环境以及参数数据，并与spring结合
//实现细节：在web容器（tomcat）初始化结束后，会加载项目项目根路径下的META-INF/services/javax.servlet.ServletContainerInitializer文件中的类，并根据该类配置初始化spring容器
//过程：tomcat加载》》》找web容器初始化文件》》》加载Spring类》》》实例化项目容器配置类》》》实例化项目容器即spring容器

//这个@HandlesTypes注解表示：会找到所有web应用程序的初始化器，供后面使用【所以只要实现了对应的容器初始化器的接口的实现类都被找到并用来加载后初始化spring容器】
@HandlesTypes({MyWebApplicationInitializer.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

	//tomcat启动初始化后会来调用这个onStartup方法
	@Override
	public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
		//初始化spring容器的实现类都放这里--->webAppInitializerClasses
		List<MyWebApplicationInitializer> initializers = new LinkedList<>();

		if (webAppInitializerClasses != null) {
			for (Class<?> waiClass : webAppInitializerClasses) {
				// Be defensive: Some servlet containers provide us with invalid classes,
				// no matter what @HandlesTypes says...
				if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
						MyWebApplicationInitializer.class.isAssignableFrom(waiClass)) {
					try {

						//* 利用反射获取WebApplicationInitializer接口的实现者实例

						initializers.add((MyWebApplicationInitializer)
								ReflectionUtils.accessibleConstructor(waiClass).newInstance());
					}
					catch (Throwable ex) {
						throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
					}
				}
			}
		}

		if (initializers.isEmpty()) {
			//意思就是没有检测到具体的WebApplicationInitializer初始化器
			servletContext.log("尚未发现WebApplication初始化器！");
			return;
		}

		servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
		servletContext.log(initializers.size() + " 检测到WebApplicationInitializers");
		AnnotationAwareOrderComparator.sort(initializers);
		for (MyWebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}
	}

