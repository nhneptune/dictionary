module com.dictionary {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens com.dictionary to javafx.fxml;
  exports com.dictionary;
}