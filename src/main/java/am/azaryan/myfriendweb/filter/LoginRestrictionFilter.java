package am.azaryan.myfriendweb.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/login", "/register"})
public class LoginRestrictionFilter extends HttpFilter {

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res,
                          FilterChain chain) throws IOException, ServletException {
    if (req.getSession().getAttribute("user") != null) {
      res.sendRedirect("home");
      return;
    }
    chain.doFilter(req, res);
  }
}
