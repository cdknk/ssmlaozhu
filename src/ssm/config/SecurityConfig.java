package ssm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired // 注入的是我们自定义的UserServiceImpl @Service
	private UserDetailsService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Fluent API
		http.authorizeRequests()
			.antMatchers("/admin/**").access("isFullyAuthenticated() and hasRole('ADMIN')")
			.antMatchers("/assets/**", "/login").permitAll()
			.antMatchers("/**").authenticated()
			
			.and()
			
			.formLogin() // 使用表单登录
			.loginPage("/login") // 指定登录页面所在的地址
			
			.and()
			
			.rememberMe() // 记住我配置
			.tokenValiditySeconds(3 * 24 * 3600) // 有效期3天
			.userDetailsService(userService);
	}
}
