package ssm;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration 
@ComponentScan(basePackages = "ssm") 
@EnableWebMvc
@PropertySource("classpath:jdbc.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 假设控制器返回"customers"，则做如下拼接确定jsp路径
		// "/WEB-INF/jsp/" + "customers" + ".jsp"
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Bean
	@Primary // 首选
	public DataSource testDataSource(Environment env) { // 数据源的初始化依赖配置环境
		String url = env.getProperty("jdbc.url");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");
		String driverClass = env.getProperty("jdbc.driverClass");
		
		DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(driverClass);
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// GET    /assets/bootstrap/css/bootstrap.min.css
		// 资源路径    /public/bootstrap/css/bootstrap.min.css
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
	}
}
