package org.example.member.dto;

import lombok.Getter;

@Getter
public class UpdateMemberResponse {

    private final long id;
    private final String name;
    private final String email;
    private final String address;

    //생성자 단축키 alt + insert 원하는 필드 shift 로 골라서 선택

    public UpdateMemberResponse(long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
