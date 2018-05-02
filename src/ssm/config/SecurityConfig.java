package ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean // spring security需要实现UserDetailsManager的bean来获得用户信息
	public UserDetailsManager userDetailsManager() {
		InMemoryUserDetailsManager um = new InMemoryUserDetailsManager();
		um.createUser(User.withUsername("zhangsan").password("zhangsan").roles("USER").build());
		um.createUser(User.withUsername("lisi").password("lisi").roles("ADMIN").build());
		return um;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Fluent API
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/login").anonymous()
			.antMatchers("/**").authenticated()
			.and()
			.formLogin() // 使用表单登录
			.loginPage("/login"); // 指定登录页面所在的地址
	}
}
