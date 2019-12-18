package xyz.xl06.news.ben;

/**
 * 
 */
public class BannerBen {
    public BannerBen(String imageInfo) {
        ImageInfo = imageInfo;
    }

    public String getImageInfo() {
        return ImageInfo;
    }

    public void setImageInfo(String imageInfo) {
        ImageInfo = imageInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BannerBen(String imageInfo, String title) {
        ImageInfo = imageInfo;
        this.title = title;
    }

    private String ImageInfo;
    private String title;

}
