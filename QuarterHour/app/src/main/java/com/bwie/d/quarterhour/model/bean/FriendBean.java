package com.bwie.d.quarterhour.model.bean;

import java.util.List;

/**
 * Created by weicy on 2018/2/4.
 */

public class FriendBean {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":"cc0db89ab32c9969","appsecret":"F60CC2470CCCB6392F157BC98C466584","createtime":"2018-01-25T08:51:46","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1516019665955timg(4).jpg","latitude":null,"longitude":null,"mobile":"15910502179","money":null,"nickname":"哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"9AC1AB268DA46750070653F447BA1D3C","uid":1290,"userId":null,"username":"15910502179"},{"age":null,"appkey":"4395ecef6d936cf7","appsecret":"24EF479F1E12B557EBF00BE4DCE52536","createtime":"2018-01-26T13:48:08","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","latitude":null,"longitude":null,"mobile":"13666668888","money":null,"nickname":"哈哈","password":"E76E4C064F4EF340593184DD8C778E9A","praiseNum":null,"token":"C430FE881D941971191E96707532FCDC","uid":1497,"userId":null,"username":"13666668888"},{"age":null,"appkey":"8157cea74c894b5c","appsecret":"3E075303BFAD6E7521E278B90A455FBF","createtime":"2018-01-26T14:04:30","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","latitude":null,"longitude":null,"mobile":"17301393946","money":null,"nickname":"哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"57C40FDDB9D537A09B46FD83BC088ACC","uid":1600,"userId":null,"username":"17301393946"},{"age":null,"appkey":"2d11b0ade77387cf","appsecret":"AD7C3B55B57DA19CA2C47CF8AD36E39B","createtime":"2018-01-16T19:15:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13934339276","money":null,"nickname":"哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"27B430EFB6803DAC9DA0BEAED76DC9B9","uid":2584,"userId":null,"username":"13934339276"},{"age":null,"appkey":"fc39a9d87c225318","appsecret":"3AE58A4B9C4E8C6B616BADCF0FA48D1E","createtime":"2018-01-25T10:13:44","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15835165025","money":null,"nickname":"哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"A066330C57A11AE21EE70DC61E2C2F95","uid":2603,"userId":null,"username":"15835165025"},{"age":null,"appkey":"2bfa1449085b8f43","appsecret":"7028687BA153016A6B0EA4D775F87D08","createtime":"2018-01-31T09:38:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15223332333","money":null,"nickname":"张心卓大美女哈哈哈哈","password":"894162ABFE100F0D8CD82405AB3D67AC","praiseNum":null,"token":"29754A9DF144D24BAAFF37C5F593367B","uid":3625,"userId":null,"username":"15223332333"},{"age":null,"appkey":"de3b23ab10936522","appsecret":"0D85715445E7E35DC4A9674A34BEDDEC","createtime":"2017-12-10T19:27:19","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15210254789","money":null,"nickname":"哈哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"1EE4B46AF2C0F9C43F006210E20B60FA","uid":4002,"userId":null,"username":"15210254789"},{"age":null,"appkey":"53815626ecab7f6a","appsecret":"3D442B791009E47FAAC3D5C859760934","createtime":"2017-12-26T16:49:40","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15236985522","money":null,"nickname":"哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"8DDB6C570ABEF75EBB607ABEAB3885A9","uid":4876,"userId":null,"username":"15236985522"}]
     * page : -1
     */

    private String msg;
    private String code;
    private int page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : cc0db89ab32c9969
         * appsecret : F60CC2470CCCB6392F157BC98C466584
         * createtime : 2018-01-25T08:51:46
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : https://www.zhaoapi.cn/images/1516019665955timg(4).jpg
         * latitude : null
         * longitude : null
         * mobile : 15910502179
         * money : null
         * nickname : 哈哈哈
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : 9AC1AB268DA46750070653F447BA1D3C
         * uid : 1290
         * userId : null
         * username : 15910502179
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private String icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
