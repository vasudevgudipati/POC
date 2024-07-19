package com.camel.camel_tcp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


@Component
public class RestDsl extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);

        rest()
                .consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
                .post("/check").type(RequestData.class).to("direct:http-request")
                .post("/tcp-check").type(RequestData.class).to("direct:tcp-request");


        from("direct:tcp-request").bean("process","processRequest");
        from("direct:http-request").bean("csvUtils","pojoToCSV")
                .to("netty:tcp://localhost:7001?textline=true&encoding=utf8").bean("csvUtils","convertToPojo");
    }
}