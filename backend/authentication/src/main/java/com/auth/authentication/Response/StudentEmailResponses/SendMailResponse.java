package com.auth.authentication.Response.StudentEmailResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class SendMailResponse {
    private Boolean TokenIsInvalid;
    private Boolean UserNotExist;
    private Boolean MailSentSuccessfull;
    private Boolean InvalidMailDetails;
}
