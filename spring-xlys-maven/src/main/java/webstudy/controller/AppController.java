package webstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class AppController {

	@GetMapping("info")
	@ResponseBody
	public String getAppInfo() {
		return "name:app1;cost:100W";//name:app1;cost:100W
	}
}
