package org.example.member.dto;

import lombok.Getter;

@Getter
public class UpdateMemberRequest {

    private String name;
    private String email;
    private String address;

}
