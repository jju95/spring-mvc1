package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 그저 갓영한...
        ServletInputStream inputStream  = request.getInputStream(); // 데이터를 읽을수있다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 유틸리티..

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
