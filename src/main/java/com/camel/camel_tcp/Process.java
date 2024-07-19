package com.camel.camel_tcp;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.support.DefaultMessage;
import org.springframework.stereotype.Component;

@Component("process")
public class Process {

    public void processRequest(Exchange exchange){
        RequestData requestData=exchange.getMessage().getBody(RequestData.class);
        requestData.setStatus("SUCCESS");
        Message message = new DefaultMessage(exchange.getContext());
        message.setBody(requestData);
        exchange.setMessage(message);
    }
}
