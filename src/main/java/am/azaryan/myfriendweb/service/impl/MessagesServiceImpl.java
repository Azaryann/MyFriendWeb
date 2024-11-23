package am.azaryan.myfriendweb.service.impl;

import am.azaryan.myfriendweb.dao.MessagesDao;
import am.azaryan.myfriendweb.dao.sql.MessagesDaoSql;
import am.azaryan.myfriendweb.exceptions.DatabaseException;
import am.azaryan.myfriendweb.model.Message;
import am.azaryan.myfriendweb.service.MessagesService;

import java.sql.SQLException;
import java.util.List;

public class MessagesServiceImpl implements MessagesService {

  private final MessagesDao messagesDao;

  public MessagesServiceImpl() {
    this.messagesDao = new MessagesDaoSql();
  }

  @Override
  public Message add(Message message) throws DatabaseException {
    try {
      return this.messagesDao.insert(message);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }

  @Override
  public List<Message> getAllMessages(int senderId, int receiverId) throws DatabaseException {
    try {
      return this.messagesDao.fetchAll(senderId, receiverId);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }
}
