package com.nantian.shamc.approval.dto;

/**
 *
 *登陆接口返回报文
 * Created by huang on 2018/5/12.
 */

public class LoginDto {

    /**
     * status : SUCCESS
     * msg : 处理成功
     * data : {"td_useCookie":true,"td_f":"loginToHome","orgName":"业务发展一部","basepath":null,"td_password":"123456","userId":"379","menuParentBeans":null,"orgId":"458","resultMsg":"","td_CID":"20180512212429a131db","instId":"380","realName":"赵稷","password":"8d969eef6ecad3c29a3a629280e686cf","td_foo":"a","td_username":"zhaoji","menuBeans":null,"username":"zhaoji"}
     */

    private String status;
    private String msg;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        private boolean td_useCookie;
        private String td_f;
        private String orgName;
        private Object basepath;
        private String td_password;
        private String userId;
        private Object menuParentBeans;
        private String orgId;
        private String resultMsg;
        private String td_CID;
        private String instId;
        private String realName;
        private String password;
        private String td_foo;
        private String td_username;
        private Object menuBeans;
        private String username;

        public boolean isTd_useCookie() {
            return td_useCookie;
        }

        public void setTd_useCookie(boolean td_useCookie) {
            this.td_useCookie = td_useCookie;
        }

        public String getTd_f() {
            return td_f;
        }

        public void setTd_f(String td_f) {
            this.td_f = td_f;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public Object getBasepath() {
            return basepath;
        }

        public void setBasepath(Object basepath) {
            this.basepath = basepath;
        }

        public String getTd_password() {
            return td_password;
        }

        public void setTd_password(String td_password) {
            this.td_password = td_password;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getMenuParentBeans() {
            return menuParentBeans;
        }

        public void setMenuParentBeans(Object menuParentBeans) {
            this.menuParentBeans = menuParentBeans;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }

        public String getTd_CID() {
            return td_CID;
        }

        public void setTd_CID(String td_CID) {
            this.td_CID = td_CID;
        }

        public String getInstId() {
            return instId;
        }

        public void setInstId(String instId) {
            this.instId = instId;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTd_foo() {
            return td_foo;
        }

        public void setTd_foo(String td_foo) {
            this.td_foo = td_foo;
        }

        public String getTd_username() {
            return td_username;
        }

        public void setTd_username(String td_username) {
            this.td_username = td_username;
        }

        public Object getMenuBeans() {
            return menuBeans;
        }

        public void setMenuBeans(Object menuBeans) {
            this.menuBeans = menuBeans;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
