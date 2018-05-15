package com.nantian.shamc.approval.httpcallable;

import com.google.gson.Gson;
import com.nantian.shamc.approval.R;
import com.nantian.shamc.approval.dto.AgencyMeetingDto;
import com.nantian.shamc.approval.dto.AgencyWorkDto;
import com.nantian.shamc.approval.dto.agencymeeting.sub.QueryConferencesBean;
import com.nantian.shamc.approval.dto.agencywork.sub.QueryMyWorkBeansBean;
import com.nantian.shamc.approval.utils.Constant;
import com.nantian.shamc.approval.utils.Fvalue;
import com.nantian.shamc.approval.utils.LogUtil;
import com.nantian.shamc.approval.utils.OKHttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by huang on 2018/5/14.
 */

public class MainFrameCallable implements Callable {
    private int flag;
    private String username;
    private String url;
    private List<Map<String, Object>> dataList;

    public MainFrameCallable(int flag, String username, String url) {
        this.flag = flag;
        this.username = username;
        this.url = url;
    }

    @Override
    public Object call() throws Exception {

        //调用接口实现查询代办会议
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.F, Fvalue.QUERY_AGENCY_WORK);
        map.put(Constant.FOO, Constant.FOO_A);
        map.put(Constant.APPLICANT, username);
        dataList = new ArrayList<Map<String, Object>>();
        if (Constant.MAIN_FRAME_CALLABLE_QUERYAGENCYWORK == flag) {
            String jsonMessage = new Gson().toJson(map);
            String returnMessage = OKHttpUtils.doPost("QUERY_AGENCY_WORK", url, jsonMessage);
            LogUtil.e("QUERY_AGENCY_WORK", "待办会议请求数据为：" + jsonMessage + "返回数据:" + returnMessage);
            if (returnMessage != null) {
                AgencyMeetingDto meetingDto = new Gson().fromJson(returnMessage, AgencyMeetingDto.class);
                List<QueryConferencesBean> queryConferences = meetingDto.getData().getQueryConferences();
                for (QueryConferencesBean queryConferencesBean : queryConferences) {
                    Map<String, Object> mapTemp = new HashMap();
                    mapTemp.put("title", queryConferencesBean.getConfprojectname());
                    mapTemp.put("time", queryConferencesBean.getConftime());
                    mapTemp.put("sponsor", queryConferencesBean.getConfownername());
                    if (Constant.MEETING_CONF_CLOSE.equals(queryConferencesBean.getConfclose())) {
                        mapTemp.put("newpic", R.drawable.newpic);
                    }
                    dataList.add(mapTemp);
                }
            }
        } else {
            //调用接口实现查询代办工作
            map.put(Constant.F, Fvalue.QUERY_ALL_AGENCY_WORK);
            map.put(Constant.FOO, Constant.FOO_A);
            map.put(Constant.APPLICANT, username);
            String jsonMessage = new Gson().toJson(map);
            String returnMessage = OKHttpUtils.doPost("QUERY_ALL_AGENCY_WORK", url, jsonMessage);
            LogUtil.e("QUERY_ALL_AGENCY_WORK", "待办工作请求报文：" + jsonMessage + "  返回数据:" + returnMessage);
            if (returnMessage != null) {
                AgencyWorkDto workDto = new Gson().fromJson(returnMessage, AgencyWorkDto.class);
                List<QueryMyWorkBeansBean> queryMyWorkBeansBeanList = workDto.getData().getQueryMyWorkBeans();
                for (QueryMyWorkBeansBean queryMyWorkBeansBean : queryMyWorkBeansBeanList) {
                    Map<String, Object> mapTemp = new HashMap();
                    mapTemp.put("title", queryMyWorkBeansBean.getBusiflowname());
                    mapTemp.put("time", queryMyWorkBeansBean.getApplytime());
                    mapTemp.put("sponsor", queryMyWorkBeansBean.getApplicant());
                    if (Constant.WORK_EXECUTE_STAT.equals(queryMyWorkBeansBean.getExecutestat())) {
                        mapTemp.put("newpic", R.drawable.newpic);
                    }
                    dataList.add(mapTemp);
                }
            }
        }
        return dataList;
    }
}
