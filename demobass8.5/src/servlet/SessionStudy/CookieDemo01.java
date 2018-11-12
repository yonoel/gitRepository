package servlet.SessionStudy;

import java.beans.Encoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo01
 */
@WebServlet("/CookieDemo01")
public class CookieDemo01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("deprecation")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response set charset
        response.setCharacterEncoding("UTF-8");
        // request set charset
        request.setCharacterEncoding("UTF-8");
        // get writer
        PrintWriter writer = response.getWriter();
        // get cookies
        Cookie[] cookies = request.getCookies();
        // cookie isn't support chinease so : Cookie cookie = new Cookie(name,URLEncoder.encode(str)) URLEncode
        if (cookies == null) {
            writer.print("this is first time to this page");
        } else {
            writer.print("your last visted time is:");
            Optional<Cookie> cookie = Stream.of(cookies).filter(p -> p.getName().equals("lastAccessTime")).findAny();
            writer.println(new Date(Long.parseLong(cookie.orElse(new Cookie("lastAccessTime", "1000")).getValue()))
                    .toLocaleString());
        }
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        cookie.setMaxAge((60 * 60 * 24));
        response.addCookie(cookie);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
