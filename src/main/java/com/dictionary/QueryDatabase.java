package com.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDatabase {

  private static QueryDatabase instance = null;
  private String url = "C:\\Users\\admin\\IdeaProjects\\dictionary\\dict_hh.db";
  private Connection connection = null;
  private QueryDatabase() {
    try {
      connection = DriverManager.getConnection("jdbc:sqlite:" + url);
      if (connection == null) {
        System.out.println("Khong the ket noi toi database");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static QueryDatabase getInstance() {
    if (instance == null) {
      instance = new QueryDatabase();
    }
    return instance;
  }
  public ResultSet search(String word) {
    String sql =
        "SELECT * FROM av WHERE word LIKE" + "'" + word + "%'";
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      return rs;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public void add(Word new_Word) {
    String sql = "INSERT INTO av VALUES ('" + new_Word.getWord() + "', '" + new_Word.getPronounce() + "', '" + new_Word.getDescription() + "')";
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(Word selectedWord) {
    String sql = "DELETE FROM av WHERE html = '" + selectedWord.getHtml() + "'";
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
