package am.azaryan.myfriendweb.dao.sql;

import am.azaryan.myfriendweb.db.DBConnectionProvider;

abstract class BaseSql {

  protected DBConnectionProvider dbConnectionProvider;

  BaseSql() {
    this.dbConnectionProvider = DBConnectionProvider.getInstance();
  }
}
