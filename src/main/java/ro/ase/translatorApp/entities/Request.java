package ro.ase.translatorApp.entities;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class Request {

    private final String REQUEST_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=";

    //required parameters
    private UUID requestId;
    private String requestKey;
    private String requestInput;
    private String requestFirstLanguage;
    private String requestSecondLanguage;

    //optional parameters
    private String requestInputFormat;
    private boolean requestOptions;

    public UUID getRequestId() {
        return requestId;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public String getRequestInput() {
        return requestInput;
    }

    public String getRequestFirstLanguage() {
        return requestFirstLanguage;
    }

    public String getRequestSecondLanguage() {
        return requestSecondLanguage;
    }

    public String getRequestInputFormat() {
        return requestInputFormat;
    }

    public boolean getRequestOptions() {
        return requestOptions;
    }

    public String createUrl() {
        return  REQUEST_URL + getRequestKey() + "&text=" + getRequestInput()
                + "&lang=" + getRequestFirstLanguage() + "-" + getRequestSecondLanguage() +
                (StringUtils.isEmpty(getRequestInputFormat()) ? "" : "&format=" + getRequestInputFormat()) +
                "&options=" + (getRequestOptions() ? 1 : 0);

    }

    private Request(RequestBuilder builder) {
        this.requestId = builder.requestId;
        this.requestKey = builder.requestKey;
        this.requestInput = builder.requestInput;
        this.requestFirstLanguage = builder.requestFirstLanguage;
        this.requestSecondLanguage = builder.requestSecondLanguage;
        this.requestInputFormat = builder.requestInputFormat;
        this.requestOptions = builder.requestOptions;
    }

    //Builder class
    public static class RequestBuilder {

        //required parameters
        private UUID requestId;
        private String requestKey;
        private String requestInput;
        private String requestFirstLanguage;
        private String requestSecondLanguage;

        //optional parameters
        private String requestInputFormat;
        private boolean requestOptions;

        public RequestBuilder(UUID requestId, String requestKey, String requestInput, String requestFirstLanguage, String requestSecondLanguage) {
            this.requestId = requestId;
            this.requestKey = requestKey;
            this.requestInput = requestInput;
            this.requestFirstLanguage = requestFirstLanguage;
            this.requestSecondLanguage = requestSecondLanguage;
        }

        public RequestBuilder setRequestInputFormat(String requestInputFormat) {
            this.requestInputFormat = requestInputFormat;
            return this;
        }

        public RequestBuilder setRequestOptions(boolean requestOptions) {
            this.requestOptions = requestOptions;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}