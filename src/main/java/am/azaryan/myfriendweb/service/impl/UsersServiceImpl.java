package am.azaryan.myfriendweb.service.impl;

import am.azaryan.myfriendweb.dao.UsersDao;
import am.azaryan.myfriendweb.dao.sql.UsersDaoSql;
import am.azaryan.myfriendweb.db.DBConnectionProvider;
import am.azaryan.myfriendweb.exceptions.DatabaseException;
import am.azaryan.myfriendweb.exceptions.FileUploadException;
import am.azaryan.myfriendweb.model.User;
import am.azaryan.myfriendweb.service.UsersService;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UsersServiceImpl implements UsersService {

  private final UsersDao usersDao;

  public UsersServiceImpl() {
    this.usersDao = new UsersDaoSql();
  }

  @Override
  public User add(User user, InputStream imageContent) throws DatabaseException, FileUploadException {
    String imageName = UUID.nameUUIDFromBytes(user.getEmail().getBytes()).toString();
    String path = UsersServiceImpl.class.getClassLoader().getResource("../../images").getFile() + imageName;
    try (Connection connection = DBConnectionProvider.getInstance().getConnection()) {
      if (imageContent != null) {
        try (OutputStream out = new FileOutputStream(path)) {
          byte[] buffer = new byte[2048];
          int readCount;
          while ((readCount = imageContent.read(buffer)) > -1) {
            out.write(buffer, 0, readCount);
          }
          user.setImageUrl("/images/" + imageName);
        } catch (IOException e) {
          throw new FileUploadException(e);
        }
      } else {
        user.setImageUrl("/images/incognito.png");
      }
      try {
        user = this.usersDao.insert(connection, user);
        connection.commit();
      } catch (SQLException e) {
        connection.rollback();
        throw e;
      }
      return user;
    } catch (SQLException e) {
      if (user.getId() > 0) {
        new File(path).delete();
      }
      throw new DatabaseException(e);
    }
  }

  @Override
  public Optional<User> get(int id) throws DatabaseException {
    try {
      return this.usersDao.fetch(id);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }

  @Override
  public Optional<User> get(String email, String password) throws DatabaseException {
    try {
      return this.usersDao.fetch(email, password);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }

  @Override
  public boolean userExist(String email) throws DatabaseException {
    try {
      return this.usersDao.userExist(email);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }

  @Override
  public List<User> getAll() throws DatabaseException {
    try {
      return this.usersDao.fetchAll();
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }
}
