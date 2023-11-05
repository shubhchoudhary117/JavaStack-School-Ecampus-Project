package com.auth.authentication.Response.FeesPayResponses;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Component
@Data
@RequiredArgsConstructor
@ToString
public class PaidFeesResponse {
    private Boolean FeesPaySuccessfull;
    private Boolean Somethingwentwrong;
    private Boolean studentIsInvalid;
    private SixClassStudentsFeesModel feesModel;
}
