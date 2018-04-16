package ssm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration 
@ComponentScan(basePackages = "ssm") 
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 假设控制器返回"customers"，则做如下拼接确定jsp路径
		// "/WEB-INF/jsp/" + "customers" + ".jsp"
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
}
