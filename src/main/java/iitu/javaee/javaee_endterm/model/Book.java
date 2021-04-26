package iitu.javaee.javaee_endterm.model;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer id;
    private String name;
    private Integer cost;
    private String urlImage;

    // constrictor
    public Book() {
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
