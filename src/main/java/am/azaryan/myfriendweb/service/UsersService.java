package am.azaryan.myfriendweb.service;

import am.azaryan.myfriendweb.exceptions.DatabaseException;
import am.azaryan.myfriendweb.exceptions.FileUploadException;
import am.azaryan.myfriendweb.model.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface UsersService {

  User add(User user, InputStream imageContent) throws DatabaseException, FileUploadException;

  Optional<User> get(int id) throws DatabaseException;

  Optional<User> get(String email, String password) throws DatabaseException;

  boolean userExist(String email) throws DatabaseException;

  List<User> getAll() throws DatabaseException;
}
