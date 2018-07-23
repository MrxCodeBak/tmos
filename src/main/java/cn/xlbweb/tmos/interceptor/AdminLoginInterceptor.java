package cn.xlbweb.tmos.interceptor;

import cn.xlbweb.tmos.common.WebConst;
import cn.xlbweb.tmos.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: bobi
 * @date: 2018/7/18 18:51
 * @description:
 */
@Slf4j
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        log.info("后台管理系统登录拦截,地址-->{}", url);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(WebConst.SESSION_USER);
        if (user != null) {
            return true;
        }
        // 用户未登录跳转到登录页面
        response.sendRedirect("/admin/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
