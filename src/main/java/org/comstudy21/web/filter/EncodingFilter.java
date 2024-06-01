package org.comstudy21.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 웹.xml에서 설정한 인코딩 값을 가져옴
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)	throws IOException, ServletException {
        // 요청 및 응답의 인코딩 설정
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
		response.setContentType("text/html; charset="+encoding);

        // 다음 필터 또는 서블릿 호출
        System.out.println("request 필터 실행 완료");
		// chain.doFilter() 호출 위는 request 필터 영역 , 전처리
			
		chain.doFilter(request, response); // 다음 요청 단계로 넘어 간다.
			
		// chain.doFilter() 호출 아래는 response 필터 영역, 후처리
		System.out.println("response 필터 실행 완료");
    }

    @Override
    public void destroy() {
        // 필터 종료 시 수행할 작업
    }

}
