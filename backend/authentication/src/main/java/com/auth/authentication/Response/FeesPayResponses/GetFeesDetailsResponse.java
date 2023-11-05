package com.auth.authentication.Response.FeesPayResponses;

import java.util.List;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Component
public class GetFeesDetailsResponse {
    private Boolean TokenIsInvalid;
    private Boolean SomethingWentWrong;
    private List<SixClassStudentsFeesModel> feesDetails;
    
}
