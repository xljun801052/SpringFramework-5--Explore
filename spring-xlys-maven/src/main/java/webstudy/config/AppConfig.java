package webstudy.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("webstudy.controller")
public class AppConfig {

	static Log log = LogFactory.getLog(AppConfig.class);

	static {
		log.info("AppConfig进行加载...");
	}
}
