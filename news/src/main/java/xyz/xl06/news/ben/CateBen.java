package xyz.xl06.news.ben;

import java.io.Serializable;

/**
 * Created by xueliang on 2019/2/16 0016.
 */
public class CateBen implements Serializable{
    public CateBen() {

    }

    public CateBen(String title, String url) {
        this.title = title;
        this.url = url;
    }

    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CateBen(String title,  String url,int id) {
        this.title = title;
        this.id = id;
        this.url = url;
    }

    private int id;
    private String url;
}
