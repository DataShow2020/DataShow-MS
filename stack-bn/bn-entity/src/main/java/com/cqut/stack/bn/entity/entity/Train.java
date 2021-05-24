package com.cqut.stack.bn.entity.entity;
import lombok.Data;

import java.util.Date;

@Data
public class Train {
    private Integer id;
    private String projName;
    private String projCode;
    private String projItem;
    private String callUnit;
    private String region;
    private String ancmTime;
    private String actual_price;
    private String callUnitAddress;
    private String projRelP;//项目联系人
    private String projRelM;
    private String agentUnitName;
    private String agentUnitAddress;
    private String agentUnitP;//'代理机构联系人
    private String agentUnitM;//代理机构联系方式
    private String purchaseM;//采购方式
    private String sourseUrl;//公告网页URL
    private Date bidTime;//开标时间
    private String provideUnit;
    private String provideAddress;
    private Date reviewTime;
    private String reviewPlace;
    private String pxyFeeStandard;//代理机构收费标准
    private String pxyFee;//代理机构收费金额
    private String title;
    private String webSite;
    private String sourceWebName;
}
