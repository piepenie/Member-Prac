package org.example.member.dto;

import lombok.Getter;

@Getter
public class GetMemberResponse {

    private final long id;
    private final String name;
    private final String email;
    private final String address;

    public GetMemberResponse(long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
