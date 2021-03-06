package com.bwie.d.quarterhour.model.bean;

import java.util.List;

/**
 * Created by 张继业 on 2018/1/23.
 */

public class VideoBean {

    /**
     * msg : 获取热门作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512542334943PictureSelector_20171206_143743.mp4","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":92,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151425855261420171226112227.jpg","nickname":"jinlin","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542334943PictureSelector_20171206_143743.mp4","wid":78,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254239806820171206143946.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":146,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/146.jpg","nickname":"昵称是一个萝卜","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542398068video_20171206_143923.mp4","wid":79,"workDesc":"这次"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254244560020171206144014.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":146,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/146.jpg","nickname":"昵称是一个萝卜","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542445600video_20171206_143923.mp4","wid":80,"workDesc":"123"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254272558420171206144516.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":146,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/146.jpg","nickname":"昵称是一个萝卜","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542725584video_20171206_144430.mp4","wid":81,"workDesc":"这次崩溃了吗？"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512545215334截屏_20171205_224521.png","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40.040467","localUri":null,"longitude":"116.300069","playNum":0,"praiseNum":0,"uid":99,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151437149690320171227104217.jpg","nickname":"祝又忠","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512545215334PictureSelector_20171206_152615.mp4","wid":82,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512545259631y.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"4545454","localUri":null,"longitude":"4545","playNum":0,"praiseNum":0,"uid":142,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512300197115y.jpg","nickname":"7897878","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512545259631PictureSelector_20171205_150755.mp4","wid":83,"workDesc":"叮叮当"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254950635020171206163810.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":114,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514361647822007.jpg","nickname":"linnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549506350video_20171206_163745.mp4","wid":84,"workDesc":"发布视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254966761520171206164052.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":114,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514361647822007.jpg","nickname":"linnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549667615video_20171206_164024.mp4","wid":85,"workDesc":"发布视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254968384920171206164052.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":114,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514361647822007.jpg","nickname":"linnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549683849video_20171206_164024.mp4","wid":86,"workDesc":"发布视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254969142820171206164052.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":114,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514361647822007.jpg","nickname":"linnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549691428video_20171206_164024.mp4","wid":87,"workDesc":"发布视频"}]
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
         * cover : https://www.zhaoapi.cn/images/quarter/1512542334943PictureSelector_20171206_143743.mp4
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 0
         * latitude : 40
         * localUri : null
         * longitude : 116
         * playNum : 0
         * praiseNum : 0
         * uid : 92
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151425855261420171226112227.jpg","nickname":"jinlin","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512542334943PictureSelector_20171206_143743.mp4
         * wid : 78
         * workDesc :
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
             * icon : https://www.zhaoapi.cn/images/151425855261420171226112227.jpg
             * nickname : jinlin
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
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
