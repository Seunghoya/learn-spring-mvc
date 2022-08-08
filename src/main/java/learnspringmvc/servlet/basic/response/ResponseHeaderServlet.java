package learnspringmvc.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // [status-line]
        res.setStatus(HttpServletResponse.SC_OK); // 200

        // [response-headers]
        res.setHeader("Content-Type", "text/plain;charset=utf-8");
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("my-header", "hello");    // 임의의 헤더도 만들 수 있다.

        res.getWriter().write("ok");

    }
    // Content 편의 메서드
    private void content(HttpServletResponse res) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //res.setHeader("Content-Type", "text/plain;charset=utf-8");
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        //res.setContentLength(2); //(생략시 자동 생성)
    }

    // Cookie 편의 메서드
    private void cookie(HttpServletResponse res) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //res.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        res.addCookie(cookie);
    }

    // redirect 편의 메서드
    private void redirect(HttpServletResponse res) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        //res.setStatus(HttpServletResponse.SC_FOUND); //302
        //res.setHeader("Location", "/basic/hello-form.html");
        res.sendRedirect("/basic/hello-form.html");
    }

}
