package com.bwie.d.quarterhour.model.bean;

import java.util.List;

/**
 * Created by d on 2018/1/22.
 */

public class CrossTalkBean {


    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"52855","createTime":"2017-12-14T19:38:23","imgUrls":null,"jid":944,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"111111","createTime":"2017-12-14T19:34:59","imgUrls":null,"jid":943,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"111111","createTime":"2017-12-14T19:34:36","imgUrls":null,"jid":942,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"★","createTime":"2017-12-14T15:58:00","imgUrls":"https://www.zhaoapi.cn/images/quarter/151323828006853eb862c9d6151b.jpg","jid":941,"praiseNum":null,"shareNum":null,"uid":77,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512203571490dsf.jpg","nickname":"若水","praiseNum":"null"}},{"commentNum":null,"content":"！！！","createTime":"2017-12-14T15:47:31","imgUrls":"https://www.zhaoapi.cn/images/quarter/15132376517871513123474982.jpeg","jid":940,"praiseNum":null,"shareNum":null,"uid":195,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514258580051mo.jpg","nickname":"nnnnnn","praiseNum":"null"}},{"commentNum":null,"content":"阿里向腾讯宣战！","createTime":"2017-12-14T11:42:26","imgUrls":"https://www.zhaoapi.cn/images/quarter/151322294630389d61f5ca65e434cbdcb38326aceb1d0.jpeg","jid":939,"praiseNum":null,"shareNum":null,"uid":313,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512179277240a.jpg","nickname":"小五","praiseNum":"null"}},{"commentNum":null,"content":"963","createTime":"2017-12-13T17:10:57","imgUrls":null,"jid":938,"praiseNum":null,"shareNum":null,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"}},{"commentNum":null,"content":"version=23","createTime":"2017-12-13T15:27:06","imgUrls":"https://www.zhaoapi.cn/images/quarter/15131500262401.gif","jid":937,"praiseNum":null,"shareNum":null,"uid":3046,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514267920084image2017122613583798436.png","nickname":"TFC","praiseNum":"null"}},{"commentNum":null,"content":"请输入内容","createTime":"2017-12-13T15:22:54","imgUrls":"https://www.zhaoapi.cn/images/quarter/1513149774131RedPackageIcon.png","jid":936,"praiseNum":null,"shareNum":null,"uid":3046,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514267920084image2017122613583798436.png","nickname":"TFC","praiseNum":"null"}},{"commentNum":null,"content":"1","createTime":"2017-12-13T15:09:01","imgUrls":"https://www.zhaoapi.cn/images/quarter/1513148941600image.png","jid":935,"praiseNum":null,"shareNum":null,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"}}]
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
         * commentNum : null
         * content : 52855
         * createTime : 2017-12-14T19:38:23
         * imgUrls : null
         * jid : 944
         * praiseNum : null
         * shareNum : null
         * uid : 154
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
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

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15136653175981513592154181.jpg
             * nickname : 笑出腹肌的男人
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
