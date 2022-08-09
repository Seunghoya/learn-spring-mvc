package learnspringmvc.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("/httpRequestHandler")
public class MyHttpRequestHandler implements HttpRequestHandler {

    /**
     * 1. 핸들러 매핑으로 핸들러 조회
     * 2. 핸들러 어댑터 조회
     * 3. 핸들러 어댑터 실행
     */
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
