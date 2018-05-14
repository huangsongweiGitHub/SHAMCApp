package com.nantian.shamc.approval.dto;

import com.nantian.shamc.approval.dto.agencymeeting.sub.DataBean;

import java.util.List;

/**
 * Created by huang on 2018/5/14.
 */

public class AgencyMeetingDto {
    /**
     * status : SUCCESS
     * msg : 处理成功
     * data : {"queryConferences":[{"confid":"201804171427243ad255","conftime":"20180417 22:45","confownername":"赵稷","confenablequate":"","confstatus":"100011","confquateresult":"","confprojectno":"2018A06","orgname":"","confcmt":"","confenableautoclose":"","confflowno":"","confattendee":"379","confquated":"02","confsubject":"8675434566","confdesc":"qwqdqdwq","confresult":"","confprojectname":"2018A06测法12户资产包收购","confresultcomment":"","confminquate":"","confowner":"379","confeval":"2:0","confassit":"379","confprojectnum":"2018A06","confassitname":"赵稷","confclass":"02","conftype":"01","confclose":"02","confenableauto":"","confattendeename":"赵稷","confquateexpire":"","confisparticipans":"","confdate":"","confaddr":"wqdwqddwqdwqdqw"},{"confid":"20180409103404884f2a","conftime":"20180409 18:00","confownername":"赵稷","confenablequate":"","confstatus":"100011","confquateresult":"","confprojectno":"2018A06","orgname":"","confcmt":"","confenableautoclose":"","confflowno":"","confattendee":"379","confquated":"02","confsubject":"test00001","confdesc":"null","confresult":"","confprojectname":"2018A06测法12户资产包收购","confresultcomment":"","confminquate":"","confowner":"379","confeval":"2:0","confassit":"379","confprojectnum":"2018A06","confassitname":"赵稷","confclass":"02","conftype":"01","confclose":"02","confenableauto":"","confattendeename":"赵稷","confquateexpire":"","confisparticipans":"","confdate":"","confaddr":"anywhere"},{"confid":"20180403145649c36c5f","conftime":"20180402 13:25","confownername":"赵稷","confenablequate":"","confstatus":"100011","confquateresult":"","confprojectno":"2018A06","orgname":"","confcmt":"","confenableautoclose":"","confflowno":"FA2018032714122530            ","confattendee":"379","confquated":"02","confsubject":"测试会议","confdesc":"测试会议内容","confresult":"","confprojectname":"","confresultcomment":"","confminquate":"","confowner":"379","confeval":"2:0","confassit":"379","confprojectnum":"2018A06","confassitname":"赵稷","confclass":"01","conftype":"01","confclose":"03","confenableauto":"","confattendeename":"赵稷","confquateexpire":"","confisparticipans":"","confdate":"","confaddr":"公司4楼大会议室"}],"td_useCookie":true,"td_f":"queryAgencyWork","orgName":"业务发展一部","statusInfo":null,"basepath":"SHAMC","flagtype":"waitToHandle","pageInfo":{"currentPage":1,"pageCount":0,"pageSize":10,"count":0,"isMsg":1},"userId":"379","orgId":"458","resultStatus":"111111","td_CID":"20180514120254aeb111","instId":"380","realName":"赵稷","td_applicant":"zhaoji","password":"8d969eef6ecad3c29a3a629280e686cf","queryMyWorkBeans":[],"flowTypes":[{"fvalue":"项目登录","keyname":"01"},{"fvalue":"可行性方案审批","keyname":"02"},{"fvalue":"项目合同审批","keyname":"03"},{"fvalue":"项目付款审批","keyname":"04"},{"fvalue":"可行性方案审批（退出）","keyname":"05"},{"fvalue":"项目结项审批","keyname":"08"},{"fvalue":"签报（非OA事项）","keyname":"09"},{"fvalue":"处置方案执行审批","keyname":"10"},{"fvalue":"收款通知单","keyname":"11"},{"fvalue":"非项目合同审批","keyname":"12"},{"fvalue":"用印申请","keyname":"13"},{"fvalue":"方案调整审批（退出）","keyname":"14"},{"fvalue":"方案调整审批","keyname":"15"},{"fvalue":"财务入账审批","keyname":"16"},{"fvalue":"专项报告审批","keyname":"17"},{"fvalue":"定期报告审批","keyname":"18"},{"fvalue":"中介机构出入库","keyname":"19"},{"fvalue":"车辆使用","keyname":"20"},{"fvalue":"档案借阅","keyname":"21"}],"td_foo":"a","td_JSESSIONID":"81525595CABF16E8FAF48A55EB07ECB6","td_username":"zhaoji","username":"zhaoji"}
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
}
