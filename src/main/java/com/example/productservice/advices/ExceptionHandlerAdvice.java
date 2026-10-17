package com.example.productservice.advices;

import com.example.productservice.dtos.ArithmeticExceptionDto;
import com.example.productservice.dtos.ArrayIndexOutOfBoundExceptionDto;
import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
 public class  ExceptionHandlerAdvice {

 @ExceptionHandler(ArithmeticException.class)
 public ResponseEntity<ArithmeticExceptionDto> HandleArithmeticException(){
           ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
           dto.setMessage("Something Went Wrong");
           return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
 }

 public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleAIOBException(){
          return null;
 }
 @ExceptionHandler(InvalidProductIdException.class)
 public ResponseEntity<ExceptionDto> handleInvalidProductIdException(){
      ExceptionDto dto = new ExceptionDto();
      dto.setMessage("Invalid ProductId Passed,Please Try again Later");
      return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND); 
 }
}
