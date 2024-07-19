package com.camel.camel_tcp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class TcpRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("netty:tcp://localhost:7000?textline=true&encoding=utf8").to("direct:to-post");


        restConfiguration().host("localhost").port(8080).bindingMode(RestBindingMode.json);

        from("direct:to-post").bean("csvUtils","convertToPojo")
                .to("rest:post:services/tcp-check").bean("csvUtils","convertToCSV");


        from("netty:tcp://localhost:7001?textline=true&encoding=utf8").bean("csvUtils","processRequest");
    }
}
