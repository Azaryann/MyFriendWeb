package am.azaryan.myfriendweb.servlets.users;

import am.azaryan.myfriendweb.service.MessagesService;
import am.azaryan.myfriendweb.service.UsersService;
import am.azaryan.myfriendweb.service.impl.MessagesServiceImpl;
import am.azaryan.myfriendweb.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

abstract class BaseUserServlet extends HttpServlet {

  protected UsersService usersService;
  protected MessagesService messagesService;

  @Override
  public void init() throws ServletException {
    super.init();
    this.usersService = new UsersServiceImpl();
    this.messagesService = new MessagesServiceImpl();
  }
}
