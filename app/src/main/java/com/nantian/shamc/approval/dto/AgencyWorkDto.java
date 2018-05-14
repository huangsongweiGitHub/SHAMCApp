package com.nantian.shamc.approval.dto;

import com.nantian.shamc.approval.dto.agencywork.sub.DataBean;

import java.util.List;

/**
 * Created by huang on 2018/5/14.
 */

public class AgencyWorkDto {


    /**
     * status : SUCCESS
     * msg : 处理成功
     * data : {"td_useCookie":true,"td_f":"queryAllAgencywork","orgName":"业务发展一部","statusInfo":null,"basepath":"SHAMC","flagtype":"waitToHandle","pageInfo":null,"userId":"379","orgId":"458","resultStatus":"111111","td_CID":"20180514121853d48d10","instId":"380","realName":"赵稷","td_applicant":"zhaoji","password":"8d969eef6ecad3c29a3a629280e686cf","queryMyWorkBeans":[{"oarequestid":"","processid2":"20170709161844000006","oaoperator":"","flowstat":"01","flowtype2":"03","taskname":"项目合同审核","flowcontext2":"","busiflowno2":"HT2018051411083451            ","userid":"379","operator":"赵稷","operator2":"赵稷","resv42":"","authoruserid2":"","flowtype_des":"项目合同审批","oatime2":"","applytime2":"20180514110835","ismulti2":"02","flowlink":"业务部门经办人发起","ismulti":"02","flowstat_des":"正常","oaflowlink2":"","taskname2":"项目合同审核","oaflowlink":"","projectno":"2018A01","busiflowno":"HT2018051411083451            ","resv12":"","busiflowname":"12332123321","oarequestid2":"","resv52":"","operationtime":"20180514110835","flowlink2":"01","flowstat2":"01","applicantno2":"379","applicant2":"赵稷","operationtime2":"20180514110835","busiflowname2":"12332123321","authoruserid":"","projectno2":"2018A01","executestat2":"01","executestat_des":"待完成","exitflowno2":"","flowno":"201805141108350000013188","resv22":"","comments2":"","applicantno":"379","comments":"","oaoperator2":"","executestat":"01","oatime":"","resv4":"","resv5":"","resv2":"","flowcontext":"","resv3":"","applytime":"20180514110835","resv1":"","flowtype":"03","applicant":"赵稷","processid":"20170709161844000006","userid2":"379","resv32":"","flowno2":"201805141108350000013188","exitflowno":""}],"td_foo":"a","td_JSESSIONID":"36F72E5C9BBC69C294B02B98AEA14013","td_username":"zhaoji","username":"zhaoji"}
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
