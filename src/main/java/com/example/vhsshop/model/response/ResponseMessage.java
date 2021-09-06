package com.example.vhsshop.model.response;

import lombok.Data;

@Data
public abstract class ResponseMessage {

    private String message;

    public ResponseMessage() {}

    public ResponseMessage(String message) { this.message = message;}

}