package xyz.xl06.news.leftmenu;

/**
 * Created by xueliang on 2019/2/15 0015.
 */
public class LeftBen {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public LeftBen() {

    }

    public LeftBen( int ico,String title) {
        this.title = title;
        this.ico = ico;
    }

    private int ico;
    private  String title;
}
