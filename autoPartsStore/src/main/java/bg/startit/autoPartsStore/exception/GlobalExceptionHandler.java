package bg.startit.autoPartsStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    private Map<String, String> getMap(String message) {

        Map<String, String> errors = new HashMap<>();
        errors.put("timestamp: ", LocalDateTime.now().toString());
        errors.put("message: ", message);

        return errors;
    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Map<String, String>> handleNoDataException(NoDataException exception)
    {
        Map<String, String> errors = getMap(exception.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleElementAlreadyExistsException(ElementAlreadyExistsException exception)
    {
        Map<String, String> errors = getMap(exception.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequestException(BadRequestException exception)
    {
        Map<String, String> errors = getMap(exception.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
