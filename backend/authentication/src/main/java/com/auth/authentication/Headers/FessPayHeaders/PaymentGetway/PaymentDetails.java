package com.auth.authentication.Headers.FessPayHeaders.PaymentGetway;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class PaymentDetails {
   private String token;
   private String ammount;
}
