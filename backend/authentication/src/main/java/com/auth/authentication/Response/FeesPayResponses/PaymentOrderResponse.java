package com.auth.authentication.Response.FeesPayResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class PaymentOrderResponse {
    private String order;
    private Boolean ammountIsInvalid;
    private Boolean internateConnection;
    private Boolean somethingwentwrong;
    private Boolean tokenIsInvalid;
    private String message;
}
