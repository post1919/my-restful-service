package com.example.myrestfulservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfoV2")
//@JsonIgnoreProperties(value = {"password", "ssn"})
public class UserV2 extends User {
     private String grade;
}
