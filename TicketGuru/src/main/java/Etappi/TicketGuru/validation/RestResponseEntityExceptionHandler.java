package Etappi.TicketGuru.validation;


import org.springframework.data.rest.core.RepositoryConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ RepositoryConstraintViolationException.class  })
    public ResponseEntity<Object> handleAccessDeniedException(
      Exception ex, WebRequest request) {
          RepositoryConstraintViolationException nevEx = 
            (RepositoryConstraintViolationException) ex;

          String errors = nevEx.getErrors().getAllErrors().stream()
           .map(p -> p.toString()).collect(Collectors.joining("\n"));
          
        //  return new ResponseEntity<Object>( "HAHHAHAHAHAHAAH",new HttpHeaders(),
        return new ResponseEntity<Object>( errors,new HttpHeaders(),
            HttpStatus.PARTIAL_CONTENT);
    }
	   public ResponseEntity<Object> handleConflictException(
			      Exception ex, WebRequest request) {
			          RepositoryConstraintViolationException nevEx = 
			            (RepositoryConstraintViolationException) ex;

			          String errors = nevEx.getErrors().getAllErrors().stream()
			           .map(p -> p.toString()).collect(Collectors.joining("\n"));
			          
			          return new ResponseEntity<Object>( errors,new HttpHeaders(),
			            HttpStatus.CONFLICT);
			    }
	 
	/*protected ResponseEntity<Object> handleConflict(
		      RuntimeException ex, WebRequest request) {
		        String bodyOfResponse = "This should be application specific";
		        return handleExceptionInternal(ex, bodyOfResponse, 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
		    }*/
	
	
	
}
