package am.azaryan.myfriendweb.servlets.messages;

import am.azaryan.myfriendweb.service.MessagesService;
import am.azaryan.myfriendweb.service.impl.MessagesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseMessagesServlet extends HttpServlet {

  protected MessagesService messagesService;

  @Override
  public void init() throws ServletException {
    super.init();
    this.messagesService = new MessagesServiceImpl();
  }
}
