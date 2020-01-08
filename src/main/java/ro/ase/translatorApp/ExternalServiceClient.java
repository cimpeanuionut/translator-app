package ro.ase.translatorApp;

import org.springframework.web.client.RestTemplate;
import ro.ase.translatorApp.abstractizations.IExternalServiceClient;
import ro.ase.translatorApp.entities.Request;
import ro.ase.translatorApp.entities.Response;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.UUID;

public class ExternalServiceClient implements IExternalServiceClient {

    @Override
    public String translate(String input, String inputLang, String outputLang) {

        final String REQUEST_KEY = "trnsl.1.1.20191212T202251Z.b915ec14d52b2f2f.4ea3f1588304c9340621af63f786e4e1d2c844dc";

        Request request = new Request.RequestBuilder(UUID.randomUUID(), REQUEST_KEY, input, inputLang, outputLang)
                .setRequestInputFormat("text").setRequestOptions(true).build();

        trustSelfSignedSSL();

        Response result = new RestTemplate().postForObject(request.createUrl(), input, Response.class);
        return result.getText().get(0).toString();
    }

    public static void trustSelfSignedSSL() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLContext.setDefault(ctx);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}