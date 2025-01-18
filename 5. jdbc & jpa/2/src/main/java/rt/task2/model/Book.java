package rt.task2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = true)
    private Integer yearpubl;

    public Book(Long id, String title, String author, Integer yearpubl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearpubl = yearpubl;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearpubl() {
        return yearpubl;
    }

    public void setYearpubl(Integer year) {
        this.yearpubl = yearpubl;
    }
}
