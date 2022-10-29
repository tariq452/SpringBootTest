package com.ttami.propertymanagment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFiledValidation(MethodArgumentNotValidException manv){

        List<ErrorModel> errorModels = new ArrayList<>();
        ErrorModel errorModel=null;
        List<FieldError>  fieldErrors= manv.getBindingResult().getFieldErrors();

        for (FieldError fe: fieldErrors){
            logger.info("Inside filed validation: {} - {} ",fe.getField(),fe.getDefaultMessage());
            logger.debug(" debug Inside filed validation: {} - {} ",fe.getField(),fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModels.add(errorModel);
        }
        return new ResponseEntity<>(errorModels, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){

        return new ResponseEntity<>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
