package xyz.xl06.news.ben;

import java.io.Serializable;

/**
 * 
 */
public class City implements Serializable{
    /**
     * status : OK
     * result : {"location":{"lng":118.776047,"lat":31.965235},"formatted_address":"江苏省南京市雨花台区龙西路","business":"铁心桥","addressComponent":{"city":"南京市","direction":"","distance":"","district":"雨花台区","province":"江苏省","street":"龙西路","street_number":""},"cityCode":315}
     */

    private String status;
    private Resultli result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Resultli getResult() {
        return result;
    }

    public void setResult(Resultli result) {
        this.result = result;
    }

    public static class Resultli implements Serializable {
        /**
         * location : {"lng":118.776047,"lat":31.965235}
         * formatted_address : 江苏省南京市雨花台区龙西路
         * business : 铁心桥
         * addressComponent : {"city":"南京市","direction":"","distance":"","district":"雨花台区","province":"江苏省","street":"龙西路","street_number":""}
         * cityCode : 315
         */

        private Locationli location;
        private String formatted_address;
        private String business;
        private AddressComponentli addressComponent;
        private int cityCode;

        public Locationli getLocation() {
            return location;
        }

        public void setLocation(Locationli location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponentli getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentli addressComponent) {
            this.addressComponent = addressComponent;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public static class Locationli implements Serializable {
            /**
             * lng : 118.776047
             * lat : 31.965235
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class AddressComponentli  implements Serializable{
            /**
             * city : 南京市
             * direction :
             * distance :
             * district : 雨花台区
             * province : 江苏省
             * street : 龙西路
             * street_number :
             */

            private String city;
            private String direction;
            private String distance;
            private String district;
            private String province;
            private String street;
            private String street_number;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }
        }
    }
}
