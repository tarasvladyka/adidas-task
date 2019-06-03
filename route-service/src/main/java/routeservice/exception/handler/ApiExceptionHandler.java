package routeservice.exception.handler;


import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import routeservice.dto.ApiResponse;
import routeservice.dto.RouteDetails;
import routeservice.enums.ApiStatusCode;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("Exception " + ex.getClass().getSimpleName() + " handled(" + ex.getMessage() + ")");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiStatusCode.VALIDATION_FAILED);
        apiResponse.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }


    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("Exception " + ex.getClass().getSimpleName() + " handled(" + ex.getMessage() + ")");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiStatusCode.VALIDATION_FAILED);
        apiResponse.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Object> handleUnexpectedException(
            Exception ex, WebRequest request) {
        logger.error(ex);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiStatusCode.INTERNAL_ERROR);
        apiResponse.setMessage("Unexpected issue");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

    @ExceptionHandler(value
            = { CompileRouteException.class})
    protected ResponseEntity<Object> handleCompileRouteException(CompileRouteException ex, WebRequest request) {
        logger.info("Exception " + ex.getClass().getSimpleName() + " handled(" + ex.getMessage() + ")");
        RouteDetails response = new RouteDetails();
        response.setCode(ApiStatusCode.UNABLE_TO_COMPILE_ROUTE);
        response.setMessage("Unable to compile route between specified cities");
        return ResponseEntity.ok(response);
    }
}