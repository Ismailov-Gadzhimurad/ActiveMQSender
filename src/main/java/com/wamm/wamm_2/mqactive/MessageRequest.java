package com.wamm.wamm_2.mqactive;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageRequest {
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("message")
    private String message;


}