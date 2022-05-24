package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebFilter(urlPatterns= {"/registration", "/login"})
public class AccessFilter extends HttpFilter {
       
	/*public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean flag = false;
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("cookie")) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		if (flag == true) {
			res.sendRedirect("login");
		} else {
			chain.doFilter(request, response);
			
		}
	}*/


}
