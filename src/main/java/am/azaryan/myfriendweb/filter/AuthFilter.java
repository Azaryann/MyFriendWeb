package am.azaryan.myfriendweb.filter;

import am.azaryan.myfriendweb.model.User;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter(filterName = "AuthFilter",
    urlPatterns = {"/home", "/usersList", "/messages", "/createMessage", "/"})
public class AuthFilter extends HttpFilter {

  private final Map<Integer, Date> USERS_ACTIVITY_MAP = new ConcurrentHashMap<>();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    filterConfig.getServletContext().setAttribute("users_activity", USERS_ACTIVITY_MAP);
  }


  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res,
                          FilterChain chain) throws IOException, ServletException {
    User user = (User) req.getSession().getAttribute("user");
    if (user == null) {
      res.sendRedirect("login");
      return;
    } else {
      USERS_ACTIVITY_MAP.put(user.getId(), new Date());
    }
    chain.doFilter(req, res);
  }
}
