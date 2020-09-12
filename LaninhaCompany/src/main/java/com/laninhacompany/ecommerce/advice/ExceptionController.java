package com.laninhacompany.ecommerce.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.laninhacompany.ecommerce.exceptions.CodigoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.EnderecoNotFoundException;
import com.laninhacompany.ecommerce.exceptions.NullObjectException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(CodigoNotFoundException.class)
	public ResponseEntity<String> CodigoNotFoundExceptions(CodigoNotFoundException e){
		String msg = e.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullObjectException.class)
	public ResponseEntity<String> NullObjectExceptions(NullObjectException e){
		String msg = e.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EnderecoNotFoundException.class)
	public ResponseEntity<String> EnderecoNotFoundExceptions(EnderecoNotFoundException e){
		String msg = e.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> DataIntegrityViolationExceptions(DataIntegrityViolationException e){
		String msg = e.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> HttpMessageNotReadableExceptions(HttpMessageNotReadableException e){
		String msg = e.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
		String msg = e.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> HttpRequestMethodNotSupportedExceptions(HttpRequestMethodNotSupportedException e){
		String msg = e.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(msg);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> trataValidacoes(MethodArgumentNotValidException e){
		Map<String, String> errosMap = new HashMap<String, String>();
		List<ObjectError> errosEncontrados = e.getBindingResult().getAllErrors();
		for (ObjectError erro : errosEncontrados) {
			FieldError fieldError = (FieldError) erro;
			String atributo = fieldError.getField();
			String mensagem = fieldError.getDefaultMessage();
			errosMap.put(atributo, mensagem);
		}
		return ResponseEntity.badRequest().body(errosMap);
	}
   
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException(NullPointerException e){
        String msg = e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
   
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> IndexOutOfBoundsException(IndexOutOfBoundsException e){
        String msg = e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
