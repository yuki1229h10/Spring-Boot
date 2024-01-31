package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Spring Securityの基本的な設定を行うクラス
 * @author Yuki
 */
@Configuration
public class DemoSecurityConfig {

	/**
	 * メモリ内でユーザ情報を管理する
	 * @return InMemoryUserDetailsManagerのインスタンス
	 */
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		// ユーザ情報の作成
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();

		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();

		// InMemoryUserDetailsManagerにユーザー情報を登録して返す
		return new InMemoryUserDetailsManager(john, mary, susan);
	}
}
