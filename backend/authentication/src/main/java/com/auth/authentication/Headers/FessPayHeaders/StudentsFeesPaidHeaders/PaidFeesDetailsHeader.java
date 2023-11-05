package com.auth.authentication.Headers.FessPayHeaders.StudentsFeesPaidHeaders;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class PaidFeesDetailsHeader {
    private String token;
    private String orderid;
    private String paymentid;
    private String ammount;
}
