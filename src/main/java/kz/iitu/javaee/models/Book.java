package kz.iitu.javaee.models;

public class Book {
    private Integer id;
    private String name;
    private Integer cost;
    private String urlImage;

    public Book() {
    }

    public Book(Integer id, String name, Integer cost, String urlImage) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.urlImage = urlImage;
    }

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
