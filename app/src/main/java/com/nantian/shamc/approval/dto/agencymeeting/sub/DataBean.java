package com.nantian.shamc.approval.dto.agencymeeting.sub;

import com.nantian.shamc.approval.dto.PageInfo;

import java.util.List;

/**
 * Created by huang on 2018/5/14.
 */

public class DataBean {
    /**
     * queryConferences : [{"confid":"201804171427243ad255","conftime":"20180417 22:45","confownername":"赵稷","confenablequate":"","confstatus":"100011","confquateresult":"","confprojectno":"2018A06","orgname":"","confcmt":"","confenableautoclose":"","confflowno":"","confattendee":"379","confquated":"02","confsubject":"8675434566","confdesc":"qwqdqdwq","confresult":"","confprojectname":"2018A06测法12户资产包收购","confresultcomment":"","confminquate":"","confowner":"379","confeval":"2:0","confassit":"379","confprojectnum":"2018A06","confassitname":"赵稷","confclass":"02","conftype":"01","confclose":"02","confenableauto":"","confattendeename":"赵稷","confquateexpire":"","confisparticipans":"","confdate":"","confaddr":"wqdwqddwqdwqdqw"},{"confid":"20180409103404884f2a","conftime":"20180409 18:00","confownername":"赵稷","confenablequate":"","confstatus":"100011","confquateresult":"","confprojectno":"2018A06","orgname":"","confcmt":"","confenableautoclose":"","confflowno":"","confattendee":"379","confquated":"02","confsubject":"test00001","confdesc":"null","confresult":"","confprojectname":"2018A06测法12户资产包收购","confresultcomment":"","confminquate":"","confowner":"379","confeval":"2:0","confassit":"379","confprojectnum":"2018A06","confassitname":"赵稷","confclass":"02","conftype":"01","confclose":"02","confenableauto":"","confattendeename":"赵稷","confquateexpire":"","confisparticipans":"","confdate":"","confaddr":"anywhere"},{"confid":"20180403145649c36c5f","conftime":"20180402 13:25","confownername":"赵稷","confenablequate":"","confstatus":"100011","confquateresult":"","confprojectno":"2018A06","orgname":"","confcmt":"","confenableautoclose":"","confflowno":"FA2018032714122530            ","confattendee":"379","confquated":"02","confsubject":"测试会议","confdesc":"测试会议内容","confresult":"","confprojectname":"","confresultcomment":"","confminquate":"","confowner":"379","confeval":"2:0","confassit":"379","confprojectnum":"2018A06","confassitname":"赵稷","confclass":"01","conftype":"01","confclose":"03","confenableauto":"","confattendeename":"赵稷","confquateexpire":"","confisparticipans":"","confdate":"","confaddr":"公司4楼大会议室"}]
     * td_useCookie : true
     * td_f : queryAgencyWork
     * orgName : 业务发展一部
     * statusInfo : null
     * basepath : SHAMC
     * flagtype : waitToHandle
     * pageInfo : {"currentPage":1,"pageCount":0,"pageSize":10,"count":0,"isMsg":1}
     * userId : 379
     * orgId : 458
     * resultStatus : 111111
     * td_CID : 20180514120254aeb111
     * instId : 380
     * realName : 赵稷
     * td_applicant : zhaoji
     * password : 8d969eef6ecad3c29a3a629280e686cf
     * queryMyWorkBeans : []
     * flowTypes : [{"fvalue":"项目登录","keyname":"01"},{"fvalue":"可行性方案审批","keyname":"02"},{"fvalue":"项目合同审批","keyname":"03"},{"fvalue":"项目付款审批","keyname":"04"},{"fvalue":"可行性方案审批（退出）","keyname":"05"},{"fvalue":"项目结项审批","keyname":"08"},{"fvalue":"签报（非OA事项）","keyname":"09"},{"fvalue":"处置方案执行审批","keyname":"10"},{"fvalue":"收款通知单","keyname":"11"},{"fvalue":"非项目合同审批","keyname":"12"},{"fvalue":"用印申请","keyname":"13"},{"fvalue":"方案调整审批（退出）","keyname":"14"},{"fvalue":"方案调整审批","keyname":"15"},{"fvalue":"财务入账审批","keyname":"16"},{"fvalue":"专项报告审批","keyname":"17"},{"fvalue":"定期报告审批","keyname":"18"},{"fvalue":"中介机构出入库","keyname":"19"},{"fvalue":"车辆使用","keyname":"20"},{"fvalue":"档案借阅","keyname":"21"}]
     * td_foo : a
     * td_JSESSIONID : 81525595CABF16E8FAF48A55EB07ECB6
     * td_username : zhaoji
     * username : zhaoji
     */

    private boolean td_useCookie;
    private String td_f;
    private String orgName;
    private Object statusInfo;
    private String basepath;
    private String flagtype;
    private PageInfo pageInfo;
    private String userId;
    private String orgId;
    private String resultStatus;
    private String td_CID;
    private String instId;
    private String realName;
    private String td_applicant;
    private String password;
    private String td_foo;
    private String td_JSESSIONID;
    private String td_username;
    private String username;
    private List<QueryConferencesBean> queryConferences;
    private List<?> queryMyWorkBeans;
    private List<FlowTypesBean> flowTypes;

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

    public Object getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(Object statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public String getFlagtype() {
        return flagtype;
    }

    public void setFlagtype(String flagtype) {
        this.flagtype = flagtype;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
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

    public String getTd_applicant() {
        return td_applicant;
    }

    public void setTd_applicant(String td_applicant) {
        this.td_applicant = td_applicant;
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

    public String getTd_JSESSIONID() {
        return td_JSESSIONID;
    }

    public void setTd_JSESSIONID(String td_JSESSIONID) {
        this.td_JSESSIONID = td_JSESSIONID;
    }

    public String getTd_username() {
        return td_username;
    }

    public void setTd_username(String td_username) {
        this.td_username = td_username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<QueryConferencesBean> getQueryConferences() {
        return queryConferences;
    }

    public void setQueryConferences(List<QueryConferencesBean> queryConferences) {
        this.queryConferences = queryConferences;
    }

    public List<?> getQueryMyWorkBeans() {
        return queryMyWorkBeans;
    }

    public void setQueryMyWorkBeans(List<?> queryMyWorkBeans) {
        this.queryMyWorkBeans = queryMyWorkBeans;
    }

    public List<FlowTypesBean> getFlowTypes() {
        return flowTypes;
    }

    public void setFlowTypes(List<FlowTypesBean> flowTypes) {
        this.flowTypes = flowTypes;
    }
}