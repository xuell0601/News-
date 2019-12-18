package xyz.xl06.news.ben;

import java.util.List;

/**
 * Created by xueliang on 2019/2/22 0022.
 */
public class VideoBen {
    private List<Trailersli> trailers;

    public List<Trailersli> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailersli> trailers) {
        this.trailers = trailers;
    }

    public static class Trailersli {
        /**
         * id : 73751
         * movieName : 《冰雪奇缘2》首支先导预告
         * coverImg : http://img5.mtime.cn/mg/2019/02/13/225753.72237488_120X90X4.jpg
         * movieId : 222095
         * url : http://vfx.mtime.cn/Video/2019/02/13/mp4/190213230123611358.mp4
         * hightUrl : http://vfx.mtime.cn/Video/2019/02/13/mp4/190213230123611358.mp4
         * videoTitle : 冰雪奇缘2 先导预告片
         * videoLength : 120
         * rating : -1
         * type : ["动画","冒险","喜剧","家庭","奇幻","歌舞"]
         * summary : 艾莎公主发大招冻住大海
         */

        private int id;
        private String movieName;
        private String coverImg;
        private int movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private int videoLength;
        private int rating;
        private String summary;
        private List<String> type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(int videoLength) {
            this.videoLength = videoLength;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}
