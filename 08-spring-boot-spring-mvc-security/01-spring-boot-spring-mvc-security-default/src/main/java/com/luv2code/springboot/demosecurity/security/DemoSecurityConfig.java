package com.luv2code.springboot.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Securityの基本的な設定を行うクラス
 * @author Yuki
 */
@Configuration
public class DemoSecurityConfig {

	// add support for JDBC ... no more hardcoded users :-)

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		// define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");

		// define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?");

		return jdbcUserDetailsManager;
	}

	/**
	 * Spring SecurityのHTTPセキュリティフィルターチェーンを設定する
	 * @param http HttpSecurityオブジェクト
	 * @return SecurityFilterChainオブジェクト
	 * @throws Exception 例外
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// すべてのHTTPリクエストに対して認証を要求する
		http.authorizeHttpRequests(
				configurer -> configurer.requestMatchers("/") // ルートパスへのアクセスは"EMPLOYEE"ロールが必要
						.hasRole("EMPLOYEE")
						.requestMatchers("/leaders/**") // "/leaders/**"へのアクセスは"MANAGER"ロールが必要
						.hasRole("MANAGER")
						.requestMatchers("/systems/**") // "/systems/**"へのアクセスは"ADMIN"ロールが必要
						.hasRole("ADMIN")
						.anyRequest() // 上記以外のすべてのリクエストに対しては認証が必要
						.authenticated())

				// フォームのログイン設定
				.formLogin(
						form -> form.loginPage("/showMyLoginPage") // カスタムログインページのパス
								.loginProcessingUrl("/authenticateTheUser") // ユーザ認証処理を担当するエンドポイント 
								.permitAll()) // ログインページへのアクセスは認証なしで許可
				.logout(logout -> logout.permitAll()) // ログアウトは認証なしで許可
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")); // アクセス拒否で表示するページ

		// 構築されたHttpSecurityをSecurityFilterChainに組み立てて返す
		return http.build();
	}

	/**
	 * メモリ内でユーザ情報を管理する
	 * @return InMemoryUserDetailsManagerのインスタンス
	 */

	/*
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
	
	*/
}
