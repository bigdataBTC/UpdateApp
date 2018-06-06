package com.xinmang.feedbackproject.bean;

/**
 * Created by lipei on 2018/6/6.
 */

public class UpdateBean {

    /**
     * code : 0
     * msg : 获取信息成功
     * data : {"id":"xiaomi","update":"Yes","new_version":"3.2","apk_file_url":"https://apk-space-1256006121.cos.ap-beijing.myqcloud.com/app-tencent-vivo.apk","target_size":"5M","update_log":"1，测试是否能更新","constraint":false}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : xiaomi
         * update : Yes
         * new_version : 3.2
         * apk_file_url : https://apk-space-1256006121.cos.ap-beijing.myqcloud.com/app-tencent-vivo.apk
         * target_size : 5M
         * update_log : 1，测试是否能更新
         * constraint : false
         */

        private String id;
        private String update;
        private String new_version;
        private String apk_file_url;
        private String target_size;
        private String update_log;
        private boolean constraint;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdate() {
            return update;
        }

        public void setUpdate(String update) {
            this.update = update;
        }

        public String getNew_version() {
            return new_version;
        }

        public void setNew_version(String new_version) {
            this.new_version = new_version;
        }

        public String getApk_file_url() {
            return apk_file_url;
        }

        public void setApk_file_url(String apk_file_url) {
            this.apk_file_url = apk_file_url;
        }

        public String getTarget_size() {
            return target_size;
        }

        public void setTarget_size(String target_size) {
            this.target_size = target_size;
        }

        public String getUpdate_log() {
            return update_log;
        }

        public void setUpdate_log(String update_log) {
            this.update_log = update_log;
        }

        public boolean isConstraint() {
            return constraint;
        }

        public void setConstraint(boolean constraint) {
            this.constraint = constraint;
        }
    }
}
