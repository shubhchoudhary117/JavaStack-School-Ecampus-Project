package com.auth.authentication.Headers.QuizeHeaders.QuestionHeaders;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@Data
@RequiredArgsConstructor
@ToString
public class QuestionsId {
    private int id;
}
