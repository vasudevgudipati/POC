package com.camel.camel_tcp;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("csvUtils")
public class CsvUtils {
 
    public RequestData convertToPojo(String csvData) {
        String[] data=csvData.split(",");
        RequestData req = new RequestData();
        req.setRequestId(Integer.valueOf(data[0]));
        req.setName(data[1]);
        req.setTransactionType(data[2]);
        req.setTransactionAmount(Integer.valueOf(data[3]));
        if(data.length>4){
            req.setStatus(data[4]);
        }
        return req;
    }

    public String convertToCSV(Exchange exchange) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String testJson = exchange.getIn().getBody(String.class);
        RequestData requestData = mapper.readValue(testJson, RequestData.class);
        return requestData.toString();
    }

    public String pojoToCSV(Exchange exchange) throws JsonProcessingException {
        RequestData requestData = exchange.getMessage().getBody(RequestData.class);
        return requestData.toString();
    }

    public String processRequest(String csvData){
        return csvData+","+"SUCCESS";
    }
}