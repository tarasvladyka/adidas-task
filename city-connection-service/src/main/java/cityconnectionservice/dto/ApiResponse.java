package cityconnectionservice.dto;

import cityconnectionservice.enums.ApiStatusCode;

public class ApiResponse {

    private ApiStatusCode code = ApiStatusCode.SUCCESS;

    private String message = "Operation performed successfully";

    public ApiStatusCode getCode() {
        return code;
    }

    public ApiResponse setCode(ApiStatusCode code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
