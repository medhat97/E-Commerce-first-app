package com.example.Ecommerce.filter;

import com.example.Ecommerce.configuration.JwtTokenProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustmFilter implements Filter {
    final JwtTokenProvider jwtTokenProvider;
    String [] allowedUrls  = {"^.*?/api/auth/login.*$"};
    @Autowired
    public CustmFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = ((HttpServletRequest) servletRequest);
        String url = servletRequest1.getRequestURL().toString();
        if (isWhiteListed(url)){

        }
        else{
            String token = servletRequest1.getHeader("Authorization");
            try {
                String email = jwtTokenProvider.extractEmail(token);
            }catch (Exception e){
                HttpServletResponse response =    ((HttpServletResponse) servletResponse);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter writer = response.getWriter();
                writer.write("error while validateing toke");
            }
        }

//        System.out.println(token);
//        System.out.println(email);
    }
    boolean isWhiteListed(String url){
        for(String whiteUrl : allowedUrls){
            if (url.matches(whiteUrl)){
                return true;
            }
        }
        return false;
    }
}
