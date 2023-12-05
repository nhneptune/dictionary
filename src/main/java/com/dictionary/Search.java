package com.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Search {

  private String searchWord;

  public Search(String searchWord) {
    this.searchWord = searchWord;
  }

  public String getSearchWord() {
    return searchWord;
  }

  public void setSearchWord(String searchWord) {
    this.searchWord = searchWord;
  }

  public Connection initConnection() {
    String url = "jdbc:sqlite:C:\\Users\\admin\\IdeaProjects\\dictionary\\dict_hh.db";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
      if (conn == null) {
        System.out.println("Khong the ket noi toi database");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public String search() {
    String sql = "SELECT * FROM av WHERE word LIKE" + "'" + searchWord + "%'";
    String result = "";
    try {
      Connection conn = this.initConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        result += rs.getString("word") + "\n";
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

//  public static void main(String[] args) {
//    java.util.Scanner sc1 = new java.util.Scanner(System.in);
//    System.out.println("Nhap tu can tim: ");
//    String searchWord = sc1.nextLine();
//    Search sc = new Search(searchWord);
//    System.out.println(sc.search());
//  }
}

