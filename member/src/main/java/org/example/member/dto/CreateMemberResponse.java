package org.example.member.dto;

import lombok.Getter;

@Getter
public class CreateMemberResponse {

    private final long id;
    private final String name;
    private final String email;
    private final String address;

    public CreateMemberResponse(long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
