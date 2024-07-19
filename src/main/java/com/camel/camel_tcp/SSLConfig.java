/*
package com.camel.camel_tcp;

import io.netty.handler.ssl.SslContextBuilder;
import org.apache.camel.support.jsse.KeyManagersParameters;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.apache.camel.support.jsse.TrustManagersParameters;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;

public class SSLConfig {
    @Bean(name = "sslContextParameters")
    public static SSLContextParameters sslParameters() throws KeyManagementException, GeneralSecurityException, IOException {

        KeyStoreParameters ksp = new KeyStoreParameters();
        ksp.setResource("C:/myfolder/test.jks");
        ksp.setPassword("jskPassword");

        KeyManagersParameters kmp = new KeyManagersParameters();
        kmp.setKeyStore(ksp);
        kmp.setKeyPassword("jskPassword");

        SSLContextParameters scp = new SSLContextParameters();
        scp.setKeyManagers(kmp);

        SSLlContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
        SSLContext sslcontext = builder.build();
        scp.createSSLContext().setDefault(sslcontext);

        // Necessary for the the self-signed server certificate
        TrustManagersParameters tmp = new TrustManagersParameters();
        tmp.setKeyStore(ksp);
        scp.setTrustManagers(tmp);

        return scp;
    }
}
*/
