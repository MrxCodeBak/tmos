package cn.xlbweb.tmos.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: bobi
 * @date: 2018/7/23 15:03
 * @description:
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 用户名
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        // 密码
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        //是否可以重置数据,这里设置为不可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }
}
