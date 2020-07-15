package annotationstudy.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
//@Service注解的value属性也可以指定注入到IOC容器的bean的beanName值
@Service("appService1")
public class AppService {
	private String name = "label-1";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AppService{" +
				"name='" + name + '\'' +
				'}';
	}
}
