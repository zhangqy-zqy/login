package com.example.springloggin.interceptor;

import com.example.springloggin.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author SHEN on 2017/4/11
 */
public class SSOLoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger LOG = LoggerFactory.getLogger(SSOLoginInterceptor.class);


    @Resource
    public LoginService loginService;


	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        loginService.putSystemMap();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 默认通过的url
     *
     * @param root       根目录，如:/ezsonar
     * @param accessPath 访问路径，如：/ezsonar/login
     * @return true或false
     */
    private boolean isDefaultUrl(String root, String accessPath) {
        return accessPath.equals(root + "/login") ||
                accessPath.equals(root + "/login/getProductList") ||
                accessPath.equals(root + "/login/getSubSystemMap") ||
                accessPath.equals(root + "/login/auth") ||
                accessPath.equals(root + "/login/authGet") ||
                accessPath.equals(root + "/restLogin/login") ||
                accessPath.equals(root + "/login/verifyToken") ||
                accessPath.equals(root + "/login/initUser") ||
                accessPath.equals(root + "/login/logout") ||
                //注册子模块，给过.
                accessPath.equals(root + "/login/registerSubSystem") ||
                accessPath.equals(root + "/login/cancelRegister") ||
                //20180110 zhangq 忽略swagger相关请求
                accessPath.startsWith(root+"/swagger");
    }
    
    /**
     * 验证license时默认通过的url
     *
     * @param root       根目录，如:/ezsonar
     * @param accessPath 访问路径，如：/ezsonar/login
     * @return true或false
     */
    private boolean isIgnoreUrl(String root, String accessPath) {
        return accessPath.equals(root + "/login") ||
                accessPath.equals(root + "/restLogin/login") ||
                accessPath.equals(root + "/login/getProductList") ||
                accessPath.equals(root + "/login/getSubSystemMap") ||
                accessPath.equals(root + "/login/auth") ||
                accessPath.equals(root + "/login/authGet") ||
                accessPath.equals(root + "/login/logout") ||
                accessPath.startsWith(root+"/login/registerSubSystem");
    }


}
