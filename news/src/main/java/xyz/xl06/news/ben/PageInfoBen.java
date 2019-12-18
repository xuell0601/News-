package xyz.xl06.news.ben;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xueliang on 2019/2/19 0019.
 */
public class PageInfoBen implements Serializable {
    /**
     * code : 200
     * data : {"list":[{"aid":"MTEyOTc1NDM","title":"孩子遇车祸救护车被堵应急车道 母亲跪地哭求让路","headpic":"http://cms-bucket.ws.126.net/2019/02/19/e2baebdbd98147f2ba4427ae804f5994.png","writer":"","source":"封面新闻","source_url":"http://auto.163.com/19/0219/14/E8CS0M21000887AJ.html","reply_count":1,"click_count":0,"pub_time":1550558307},{"aid":"MTEyOTc1NDI","title":"男子开斗气车 \"蛇形走位\"26秒别车8次","headpic":"http://cms-bucket.ws.126.net/2019/02/19/159c471ec4e54ab7953412ecbac598db.png","writer":"","source":"封面新闻","source_url":"http://auto.163.com/19/0219/14/E8CS9G7P000887AJ.html","reply_count":0,"click_count":0,"pub_time":1550558596},{"aid":"MTEyOTc1NDE","title":"欧盟希望美停止加征汽车关税 否则将采取反制措施","headpic":"http://cms-bucket.ws.126.net/2019/02/19/659a97a97a69407abb00ab6fa1f3e90e.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/17/E8D5TR7P000884MM.html","reply_count":0,"click_count":0,"pub_time":1550568700},{"aid":"MTEyOTc1NDA","title":"嫌车灯不够亮车主自己改 高速上烧成空壳","headpic":"http://cms-bucket.ws.126.net/2019/02/19/7283174dcd134ef1a81ebace49791d22.png","writer":"","source":"浙江在线-钱江晚报","source_url":"http://auto.163.com/19/0219/14/E8CRN8OE000887AJ.html","reply_count":0,"click_count":0,"pub_time":1550557999},{"aid":"MTEyOTc0OTc","title":"上汽MG品牌将进入印度市场 未来2年推4款SUV","headpic":"http://cms-bucket.ws.126.net/2019/02/19/23f50274aa9b4b65b5da0c63d0d96d74.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/15/E8D0ENM5000884MM.html","reply_count":0,"click_count":0,"pub_time":1550562962},{"aid":"MTEyOTc0ODA","title":"续航里程未公布 捷途X70 EV电动车今年上市","headpic":"http://cms-bucket.ws.126.net/2019/02/19/dfbd7a578d8643db9e0c4060d0fdd340.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/15/E8CTVD6N0008856R.html","reply_count":0,"click_count":0,"pub_time":1550560362},{"aid":"MTEyOTc0Nzk","title":"官方油耗8.4L 纳智捷新中型SUV能否翻身?","headpic":"http://cms-bucket.ws.126.net/2019/02/19/ea0d6b6555594d6786b61537b2f6d0e1.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/14/E8CRS3CR0008856R.html","reply_count":1,"click_count":0,"pub_time":1550558157},{"aid":"MTEyOTc0Nzg","title":"高配有四驱/动力参数超丰田 红旗HS5颜值惊人","headpic":"http://cms-bucket.ws.126.net/2019/02/19/ef4251b8bf9b4f79937e181f8256ebb6.jpeg","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/15/E8CTPQIQ0008856R.html","reply_count":0,"click_count":0,"pub_time":1550560180},{"aid":"MTEyOTc0Nzc","title":"预计年内上市/3.0T动力 红旗HS7霸气十足","headpic":"http://cms-bucket.ws.126.net/2019/02/19/66cc00b987c249f18faf21ade591fe76.jpeg","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/14/E8CSL7F80008856R.html","reply_count":0,"click_count":0,"pub_time":1550558980},{"aid":"MTEyOTc0NDU","title":"C2B模式/三季度上市 大通D60即将发布","headpic":"http://cms-bucket.ws.126.net/2019/02/19/b085c83239484668bec50ef07f692be1.jpeg","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/14/E8CQAT7J0008856R.html","reply_count":0,"click_count":0,"pub_time":1550556545}],"page":1,"psize":10,"count":10,"total":764}
     * msg : success
     */

    private String code;
    private Datali data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Datali getData() {
        return data;
    }

    public void setData(Datali data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class Datali implements Serializable {
        /**
         * list : [{"aid":"MTEyOTc1NDM","title":"孩子遇车祸救护车被堵应急车道 母亲跪地哭求让路","headpic":"http://cms-bucket.ws.126.net/2019/02/19/e2baebdbd98147f2ba4427ae804f5994.png","writer":"","source":"封面新闻","source_url":"http://auto.163.com/19/0219/14/E8CS0M21000887AJ.html","reply_count":1,"click_count":0,"pub_time":1550558307},{"aid":"MTEyOTc1NDI","title":"男子开斗气车 \"蛇形走位\"26秒别车8次","headpic":"http://cms-bucket.ws.126.net/2019/02/19/159c471ec4e54ab7953412ecbac598db.png","writer":"","source":"封面新闻","source_url":"http://auto.163.com/19/0219/14/E8CS9G7P000887AJ.html","reply_count":0,"click_count":0,"pub_time":1550558596},{"aid":"MTEyOTc1NDE","title":"欧盟希望美停止加征汽车关税 否则将采取反制措施","headpic":"http://cms-bucket.ws.126.net/2019/02/19/659a97a97a69407abb00ab6fa1f3e90e.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/17/E8D5TR7P000884MM.html","reply_count":0,"click_count":0,"pub_time":1550568700},{"aid":"MTEyOTc1NDA","title":"嫌车灯不够亮车主自己改 高速上烧成空壳","headpic":"http://cms-bucket.ws.126.net/2019/02/19/7283174dcd134ef1a81ebace49791d22.png","writer":"","source":"浙江在线-钱江晚报","source_url":"http://auto.163.com/19/0219/14/E8CRN8OE000887AJ.html","reply_count":0,"click_count":0,"pub_time":1550557999},{"aid":"MTEyOTc0OTc","title":"上汽MG品牌将进入印度市场 未来2年推4款SUV","headpic":"http://cms-bucket.ws.126.net/2019/02/19/23f50274aa9b4b65b5da0c63d0d96d74.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/15/E8D0ENM5000884MM.html","reply_count":0,"click_count":0,"pub_time":1550562962},{"aid":"MTEyOTc0ODA","title":"续航里程未公布 捷途X70 EV电动车今年上市","headpic":"http://cms-bucket.ws.126.net/2019/02/19/dfbd7a578d8643db9e0c4060d0fdd340.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/15/E8CTVD6N0008856R.html","reply_count":0,"click_count":0,"pub_time":1550560362},{"aid":"MTEyOTc0Nzk","title":"官方油耗8.4L 纳智捷新中型SUV能否翻身?","headpic":"http://cms-bucket.ws.126.net/2019/02/19/ea0d6b6555594d6786b61537b2f6d0e1.png","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/14/E8CRS3CR0008856R.html","reply_count":1,"click_count":0,"pub_time":1550558157},{"aid":"MTEyOTc0Nzg","title":"高配有四驱/动力参数超丰田 红旗HS5颜值惊人","headpic":"http://cms-bucket.ws.126.net/2019/02/19/ef4251b8bf9b4f79937e181f8256ebb6.jpeg","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/15/E8CTPQIQ0008856R.html","reply_count":0,"click_count":0,"pub_time":1550560180},{"aid":"MTEyOTc0Nzc","title":"预计年内上市/3.0T动力 红旗HS7霸气十足","headpic":"http://cms-bucket.ws.126.net/2019/02/19/66cc00b987c249f18faf21ade591fe76.jpeg","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/14/E8CSL7F80008856R.html","reply_count":0,"click_count":0,"pub_time":1550558980},{"aid":"MTEyOTc0NDU","title":"C2B模式/三季度上市 大通D60即将发布","headpic":"http://cms-bucket.ws.126.net/2019/02/19/b085c83239484668bec50ef07f692be1.jpeg","writer":"","source":"网易汽车","source_url":"http://auto.163.com/19/0219/14/E8CQAT7J0008856R.html","reply_count":0,"click_count":0,"pub_time":1550556545}]
         * page : 1
         * psize : 10
         * count : 10
         * total : 764
         */

        private int page;
        private int psize;
        private int count;
        private int total;
        private List<Listli> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPsize() {
            return psize;
        }

        public void setPsize(int psize) {
            this.psize = psize;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Listli> getList() {
            return list;
        }

        public void setList(List<Listli> list) {
            this.list = list;
        }

        public static class Listli implements Serializable{
            /**
             * aid : MTEyOTc1NDM
             * title : 孩子遇车祸救护车被堵应急车道 母亲跪地哭求让路
             * headpic : http://cms-bucket.ws.126.net/2019/02/19/e2baebdbd98147f2ba4427ae804f5994.png
             * writer :
             * source : 封面新闻
             * source_url : http://auto.163.com/19/0219/14/E8CS0M21000887AJ.html
             * reply_count : 1
             * click_count : 0
             * pub_time : 1550558307
             */

            private String aid;
            private String title;
            private String headpic;
            private String writer;
            private String source;
            private String source_url;
            private int reply_count;
            private int click_count;
            private int pub_time;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHeadpic() {
                return headpic;
            }

            public void setHeadpic(String headpic) {
                this.headpic = headpic;
            }

            public String getWriter() {
                return writer;
            }

            public void setWriter(String writer) {
                this.writer = writer;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getSource_url() {
                return source_url;
            }

            public void setSource_url(String source_url) {
                this.source_url = source_url;
            }

            public int getReply_count() {
                return reply_count;
            }

            public void setReply_count(int reply_count) {
                this.reply_count = reply_count;
            }

            public int getClick_count() {
                return click_count;
            }

            public void setClick_count(int click_count) {
                this.click_count = click_count;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }
        }
    }
}
