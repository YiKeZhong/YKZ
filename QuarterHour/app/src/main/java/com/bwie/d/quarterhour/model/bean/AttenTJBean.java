package com.bwie.d.quarterhour.model.bean;

import java.util.List;

/**
 * Created by ztz on 2018/1/23.
 */

public class AttenTJBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516364021918QQ截图20180118200412.png","createTime":"2018-01-19T20:13:41","favoriteNum":0,"latitude":"0","localUri":null,"longitude":"0","playNum":0,"praiseNum":0,"uid":1217,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516364021918QQ截图20180118200334.png","wid":250,"workDesc":"哈哈哈"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1515587806806151496296995.jpg","createTime":"2018-01-10T20:36:46","favoriteNum":0,"latitude":"41.6729118196","localUri":null,"longitude":"89.6484375000","playNum":0,"praiseNum":0,"uid":71,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15166102493761516610249194.png","nickname":"12","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1515587806806Video_00200.wmv","wid":249,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1515587623180151496296995.jpg","createTime":"2018-01-10T20:33:43","favoriteNum":0,"latitude":"41.6729118196","localUri":null,"longitude":"89.6484375000","playNum":0,"praiseNum":0,"uid":1217,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1515587623180Video_00200.wmv","wid":248,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514709891571cover.jpg","createTime":"2017-12-31T16:44:51","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":3,"praiseNum":0,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15147098915711514709865656.mp4","wid":247,"workDesc":" "},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514704790621column_2.png","createTime":"2017-12-31T15:19:50","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10622,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514704790621PictureSelector_20171231_151914.mp4","wid":246,"workDesc":"11"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514623018680cover.jpg","createTime":"2017-12-30T16:36:58","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":0,"praiseNum":0,"uid":88,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/88.jpg","nickname":"解杰\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514623018680videowallpaper_1005.mp4","wid":245,"workDesc":"一个个来"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514463086752tab_2_pressed.png","createTime":"2017-12-28T20:11:26","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":4,"praiseNum":1,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514463086752d74a602735ab4f70996a59c4ab1aad55.mp4","wid":244,"workDesc":"Ffd"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514463083590tab_2_pressed.png","createTime":"2017-12-28T20:11:23","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":1,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514463083590d74a602735ab4f70996a59c4ab1aad55.mp4","wid":243,"workDesc":"Ffd"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514377558791cover.jpg","createTime":"2017-12-27T20:25:58","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":1,"praiseNum":1,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15143775587911514377509492.mp4","wid":242,"workDesc":" "},{"commentNum":1,"comments":[{"cid":235,"content":"666","createTime":"2017-12-27T16:50:20","jid":null,"mvp":null,"nickname":"GUODONG.","praiseNum":0,"uid":86,"wid":241}],"cover":"https://www.zhaoapi.cn/images/quarter/151425878606620171226112617.jpg","createTime":"2017-12-26T11:26:26","favoriteNum":1,"latitude":"100","localUri":null,"longitude":"100","playNum":3,"praiseNum":2,"uid":195,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514258580051mo.jpg","nickname":"nnnnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514258786066video_20171226_112556.mp4","wid":241,"workDesc":""}]
     */

    private String msg;
    private String code;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/1516364021918QQ截图20180118200412.png
         * createTime : 2018-01-19T20:13:41
         * favoriteNum : 0
         * latitude : 0
         * localUri : null
         * longitude : 0
         * playNum : 0
         * praiseNum : 0
         * uid : 1217
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1516364021918QQ截图20180118200334.png
         * wid : 250
         * workDesc : 哈哈哈
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private Object icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
