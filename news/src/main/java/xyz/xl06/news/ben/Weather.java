package xyz.xl06.news.ben;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xueliang on 2019/2/24 0024.
 */
public class Weather implements Serializable {
    /**
     * code : 200
     * msg : 成功!
     * data : {"yesterday":{"date":"23日星期六","high":"高温 11℃","fx":"无持续风向","low":"低温 7℃","fl":"<![CDATA[<3级]]>","type":"多云"},"city":"成都","aqi":null,"forecast":[{"date":"24日星期天","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"无持续风向","type":"小雨"},{"date":"25日星期一","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"无持续风向","type":"小雨"},{"date":"26日星期二","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"无持续风向","type":"阴"},{"date":"27日星期三","high":"高温 13℃","fengli":"<![CDATA[<3级]]>","low":"低温 8℃","fengxiang":"无持续风向","type":"多云"},{"date":"28日星期四","high":"高温 11℃","fengli":"<![CDATA[<3级]]>","low":"低温 8℃","fengxiang":"无持续风向","type":"小雨"}],"ganmao":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。","wendu":"8"}
     */

    private int code;
    private String msg;
    private Datali data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Datali getData() {
        return data;
    }

    public void setData(Datali data) {
        this.data = data;
    }

    public static class Datali implements Serializable{
        /**
         * yesterday : {"date":"23日星期六","high":"高温 11℃","fx":"无持续风向","low":"低温 7℃","fl":"<![CDATA[<3级]]>","type":"多云"}
         * city : 成都
         * aqi : null
         * forecast : [{"date":"24日星期天","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"无持续风向","type":"小雨"},{"date":"25日星期一","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"无持续风向","type":"小雨"},{"date":"26日星期二","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"无持续风向","type":"阴"},{"date":"27日星期三","high":"高温 13℃","fengli":"<![CDATA[<3级]]>","low":"低温 8℃","fengxiang":"无持续风向","type":"多云"},{"date":"28日星期四","high":"高温 11℃","fengli":"<![CDATA[<3级]]>","low":"低温 8℃","fengxiang":"无持续风向","type":"小雨"}]
         * ganmao : 天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。
         * wendu : 8
         */

        private Yesterdayli yesterday;
        private String city;
        private Object aqi;
        private String ganmao;
        private String wendu;
        private List<Forecastli> forecast;

        public Yesterdayli getYesterday() {
            return yesterday;
        }

        public void setYesterday(Yesterdayli yesterday) {
            this.yesterday = yesterday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getAqi() {
            return aqi;
        }

        public void setAqi(Object aqi) {
            this.aqi = aqi;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public List<Forecastli> getForecast() {
            return forecast;
        }

        public void setForecast(List<Forecastli> forecast) {
            this.forecast = forecast;
        }

        public static class Yesterdayli implements Serializable{
            /**
             * date : 23日星期六
             * high : 高温 11℃
             * fx : 无持续风向
             * low : 低温 7℃
             * fl : <![CDATA[<3级]]>
             * type : 多云
             */

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class Forecastli  implements Serializable{
            /**
             * date : 24日星期天
             * high : 高温 10℃
             * fengli : <![CDATA[<3级]]>
             * low : 低温 7℃
             * fengxiang : 无持续风向
             * type : 小雨
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
