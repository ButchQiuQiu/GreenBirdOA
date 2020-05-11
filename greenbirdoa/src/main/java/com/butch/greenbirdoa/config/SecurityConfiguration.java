package com.butch.greenbirdoa.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.butch.greenbirdoa.security.MyAccessDecisionManager;
import com.butch.greenbirdoa.security.MySecurityMetadataSource;
import com.butch.greenbirdoa.security.handle.LoginFailedHandle;
import com.butch.greenbirdoa.security.handle.LoginSuccessHandle;
import com.butch.greenbirdoa.security.handle.MyAccessDeniedHandler;
import com.butch.greenbirdoa.security.handle.MyLogoutSuccessHandler;
import com.butch.greenbirdoa.security.service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Configuration标注这是个配置类, 将会被spring扫描配置. @EnableWebSecurity:
 * 加载了WebSecurityConfiguration配置类, 配置安全认证策略,加载了AuthenticationConfiguration,
 * 配置了认证信息。 继承了WebSecurityConfigurerAdapter,可以适配自己的webSecurity配置;
 * 除了webconfig还是其他场景使用的adapter,按照适配器模式来说的话.
 */

// 待移植security
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // 装配config所需要的组件,大部分由用户重写完成功能------------------------------

    // ---------------------------------------------验证--------------------------------------------
    // 自定义的passwordEncoder,NoPassWordEncoder为不启动密码编码,BCryptPasswordEncoder为启动BCryptPasswordEncoder编码器
    @Autowired()
    @Qualifier("NoPassWordEncoder")
    PasswordEncoder passwordEncoder;
    // 自定义详细验证类,可以对接默认的DaoAuthenticationProvider自定义验证过程
    @Autowired
    MyUserDetailsService myUserDetailsService;
    // 验证成功后的自定义处理器
    @Autowired
    LoginSuccessHandle loginSuccessHandle;
    // 验证失败后的自定义处理器
    @Autowired
    LoginFailedHandle loginFailedHandle;
    // 注销成功后的自定义处理器
    @Autowired
    MyLogoutSuccessHandler myLogoutSuccessHandler;
    // -------------------------------------------------鉴权---------------------------------------------
    // 自定义鉴权类
    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;
    // 自定义鉴权数据类,提供鉴权所需要的角色
    @Autowired
    MySecurityMetadataSource mySecurityMetadataSource;
    // 鉴权失败的自定义处理器
    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    /**
     * security提供的建造者对象可以创建基于内存的认证、LDAP认证、
     * JDBC认证，以及添加UserDetailsService和AuthenticationProvider等。
     * 
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 添加一个数据验证类和passworEncoder,此时会自动添加一个处理service的DaoAuthenticationProvider.
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 重写此方法以配置HttpSecurity,例如自定义登录页,自定义验证鉴权成功或者失败的操作等等.
     * 
     * @param http
     * 
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 处理请求,所有请求需要登录才能访问
                .authorizeRequests()
                .anyRequest().authenticated()
                // 添加鉴权的各种处理器-->过滤拦截器 ,权限拦截器在验证拦截器后执行,
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    // 初始化对象，可能会返回一个应该使用的修改过的实例。
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        // 设置提供鉴权角色类
                        // object.setSecurityMetadataSource(mySecurityMetadataSource);
                        // 设置自定义鉴权类
                        object.setAccessDecisionManager(myAccessDecisionManager);
                        // 返回添加处理器后的对象
                        return object;
                    }
                })
                .and()
                // 配置登录请求的url和登录与成功的处理器
                .formLogin().loginPage("/page-login.html").loginProcessingUrl("/login")
                .successHandler(loginSuccessHandle).failureHandler(loginFailedHandle).permitAll()
                // 设置login_p页面向login提交的表单的各个元素名.
                .usernameParameter("username").passwordParameter("password").and()
                // 设置注销请求的url和对应的自定义处理器.
                .logout().logoutUrl("/logout").logoutSuccessHandler(myLogoutSuccessHandler).permitAll().and()
            // 添加鉴权失败后的自定义处理器
            .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler)
            // 关闭默认打开的csrf攻击保护
            .and().csrf().disable()
        ;

    }

    /**
     * 过滤掉登陆界面的资源以免验证拦截等拦截器循环重定向
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/page-login.html","/assets/**", "/images/**", "/js/**", "/vendors/**", "apple-icon.png", "favicon.ico");
    }
    
    
}