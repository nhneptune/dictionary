package com.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchController {
  @FXML
  public TextField searchTextField;
  @FXML
  public ListView searchListView;

  public Connection initConnection() {
    String url = "jdbc:sqlite:C:\\Users\\admin\\IdeaProjects\\dictionary\\dict_hh.db";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
      if (conn != null) {
        DatabaseMetaData meta = conn.getMetaData();
        System.out.println("The driver name is " + meta.getDriverName());
        System.out.println("A new database has been created.");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public void search(String s) {
    String sql = "SELECT * FROM av WHERE word LIKE" + "'" + s + "'";
    try {
      Connection conn = this.initConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString("word") + "\t" + rs.getString("html"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    SearchController sc = new SearchController();
    java.util.Scanner sc1 = new java.util.Scanner(System.in);
    System.out.println("Nhap tu can tim: ");
    String s = sc1.nextLine();
    sc.search(s);
  }
}

