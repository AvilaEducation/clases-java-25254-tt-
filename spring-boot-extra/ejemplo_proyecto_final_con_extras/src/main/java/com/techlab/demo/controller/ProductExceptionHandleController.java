package com.techlab.demo.controller;

import com.techlab.demo.exception.NotFoundException;
import com.techlab.demo.model.dto.response.ErrorResponseDTO;
import com.techlab.demo.model.dto.response.ErrorResponseRecordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.techlab.demo")
public class ProductExceptionHandleController {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException e) {
    ErrorResponseDTO response = new ErrorResponseDTO();
    response.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
    response.setMessage(e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseRecordDTO> hadlerUnknowException(Exception e) {
    ErrorResponseRecordDTO response = new ErrorResponseRecordDTO(
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }
}
