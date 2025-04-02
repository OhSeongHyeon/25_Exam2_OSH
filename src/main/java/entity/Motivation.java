package entity;

import java.time.LocalDateTime;

public class Motivation {
    int id;
    LocalDateTime regDate;
    String content;
    String author;

    public Motivation() {}

    public Motivation(int id, LocalDateTime regDate, String content, String author) {
        this.id = id;
        this.regDate = regDate;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", regDate=" + regDate +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
