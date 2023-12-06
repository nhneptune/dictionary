module com.dictionary {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires javafx.web;
  requires freetts;

  opens com.dictionary to javafx.fxml;
  exports com.dictionary;
}