package EP.ExamenParcial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import EP.ExamenParcial.shared.response.ResponseError;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value=AlumnoException.class)
    public ResponseEntity<ResponseError> alumnoExceptionHandler(AlumnoException ex, WebRequest webRequest){
         ResponseError error = new ResponseError(ex.getMessage(),ex.getStatus(),webRequest.getDescription(false));
         log.error("Error processing request: {}", ex.getMessage(),ex);
         return new ResponseEntity<>(error,HttpStatusCode.valueOf(ex.getStatus()));
    }

    @ExceptionHandler(value=NoHandlerFoundException.class)
    public ResponseEntity<ResponseError> handleNotFoundException(NoHandlerFoundException ex){
        ResponseError error = new ResponseError("La ruta es incorrecta",404,ex.getRequestURL());
        log.error("Ruta no encontrada: {}", ex.getRequestURL());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
   }

}
