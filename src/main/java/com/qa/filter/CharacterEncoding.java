package com.qa.filter;
//过滤器

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncoding implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//返回的编码类型

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
