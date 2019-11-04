package com.yingnuo.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/*
*
*
* */

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 处理请求乱码
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletRequest myRequest = new MyRequest(httpServletRequest);
        // 处理响应乱码
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(myRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
// 自定义 request 对象
class MyRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;
    private boolean hasEncode;
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        Map<String,String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null){
            return null;
        }
        // 返回参数第一个值
        return values[0];
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        // 获取请求方式
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")){
            // POST
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if (method.equalsIgnoreCase("get")){
            // GET
            Map<String,String[]> parameterMap = request.getParameterMap();
            if (!hasEncode){
                // 确保 GET 手动编码逻辑只运行一次
                for (String parameterName : parameterMap.keySet()){
                    String[] values = parameterMap.get(parameterName);
                    if (values != null){
                        for (int i = 0;i<values.length;i++){
                            try {
                                values[i] = new String(values[i].getBytes("ISO-8859-1"),"utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String,String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }
}
