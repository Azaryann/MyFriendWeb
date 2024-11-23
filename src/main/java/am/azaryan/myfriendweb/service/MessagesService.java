package am.azaryan.myfriendweb.service;

import am.azaryan.myfriendweb.exceptions.DatabaseException;
import am.azaryan.myfriendweb.model.Message;

import java.util.List;

public interface MessagesService {

  Message add(Message message) throws DatabaseException;

  List<Message> getAllMessages(int senderId, int receiverId) throws DatabaseException;
}
