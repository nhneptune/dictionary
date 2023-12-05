package com.dictionary;

public class Word {
  private String word;
  private String description;
  private String pronounce;

  private String html;


  public Word(String word, String description, String pronounce, String html) {
    this.word = word;
    this.description = description;
    this.pronounce = pronounce;
    this.html = html;
  }

  public Word(String word, String pronounce, String html) {
    this.word = word;
    this.pronounce = pronounce;
    this.html = html;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPronounce() {
    return pronounce;
  }

  public void setPronounce(String pronounce) {
    this.pronounce = pronounce;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  @Override
  public String toString() {
    return this.word;
  }
}
