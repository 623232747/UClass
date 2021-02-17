package org.BUPT.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: SimpleFilter
 * @Description:  路由过滤器
 * @Author: liuhefei
 * @Date: 2019/4/1
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Component
@Slf4j
public class UserFilter extends ZuulFilter {
    /**
     * 前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否执行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //获得当前上下文，存放请求和状态信息
        RequestContext context = RequestContext.getCurrentContext();
        //获取相关信息
        HttpServletRequest request = context.getRequest();
        String method = request.getMethod();
        String url = request.getRequestURI().toString();
        String username = request.getParameter("username");
        //String headerName = request.getHeaderNames().toString();
        //String ctxPath = request.getContextPath();

        System.out.printf("%s request to %s\r\n", method, url);
        return true;
    }

    /**
     * 过滤通过后要执行的方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        log.info("pass");
        return null;
    }
}
