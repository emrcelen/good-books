package com.realworld.dto.response.rest;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RestErrorResponse implements Serializable {
    private boolean isSuccess;
    private int status;
    private String payload;
    private String responseDate;

    public RestErrorResponse(){}
    public RestErrorResponse(Builder builder){
        this.isSuccess = builder.isSuccess;
        this.status = builder.status;
        this.payload = builder.payload;
        this.responseDate = builder.responseDate;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
    public int getStatus() {
        return status;
    }
    public String getPayload() {
        return payload;
    }
    public String getResponseDate() {
        return responseDate;
    }

    public static class Builder{
        private boolean isSuccess;
        private int status;
        private String payload;
        private String responseDate;

        public Builder isSuccess(boolean isSuccess){
            this.isSuccess = isSuccess;
            return this;
        }
        public Builder status (HttpStatus httpStatus){
            this.status = httpStatus.value();
            return this;
        }
        public Builder payload (String payload){
            this.payload = payload;
            return this;
        }
        public Builder responseDate(LocalDateTime localDateTime){
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            this.responseDate = dtf.format(localDateTime);
            return this;
        }
        public RestErrorResponse build(){
            return new RestErrorResponse(this);
        }
    }
}
