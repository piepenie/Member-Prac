package org.example.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.member.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
}
