package cityconnectionservice.handler;


import cityconnectionservice.enums.ApiStatusCode;
import cityconnectionservice.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Object> handleUnexpectedException(
            Exception ex, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiStatusCode.INTERNAL_ERROR);
        apiResponse.setMessage("Unexpected issue");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

}