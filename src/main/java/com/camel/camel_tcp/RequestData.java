package com.camel.camel_tcp;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RequestData {

    private Integer requestId;
    private String name;
    private String transactionType;
    private Integer transactionAmount;
    private String status;

    public Integer getRequestId() {
        return requestId;
    }

    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String reqString=requestId +"," +name +","+transactionType +","+transactionAmount;
        if(!StringUtils.isEmpty(status))
            reqString+=","+status;
        return reqString;
    }


}
