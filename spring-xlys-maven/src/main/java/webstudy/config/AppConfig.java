package webstudy.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import webstudy.entity.App1;

@Configuration
//@Configuration相当于告诉Spring这是一个配置类，功能相当于一个配置文件beans.xml。
// 【@Configuration注解中含有@Component注解，所以配置类本身也会作为Spring中一个组件Bean】
@ComponentScan("webstudy.controller")
public class AppConfig {

	static Log log = LogFactory.getLog(AppConfig.class);

	static {
		log.info("AppConfig进行加载...");
	}

	@Bean(value = "app01")//这个注解相当于在Spring容器中注册一个Bean,功能等同于之前XML配置中的<bean id="" class="">
	//这里Class就是方法返回值类型，id默认为方法名【可以通过@Bean注解的value属性来制定】
	public App1 app(){
		return new App1();
	}
}
