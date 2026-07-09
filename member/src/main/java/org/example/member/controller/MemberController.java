package org.example.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.member.dto.*;
import org.example.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> create(@RequestBody CreateMemberRequest request){
        CreateMemberResponse result = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/members")
    public ResponseEntity<List<GetMemberResponse>> getAll() {
        List<GetMemberResponse> result = memberService.getALL();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/mebers/{memberId}")
    public ResponseEntity<GetMemberResponse> getOne(@PathVariable Long memberId){
        GetMemberResponse result = memberService.getOne(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/mebers/{memberId}")
    public ResponseEntity<UpdateMemberResponse> update(
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRequest request
            ) {
            UpdateMemberResponse result = memberService.update(memberId, request);
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/mebers/{memberId}")
    public ResponseEntity<Void> delete(@PathVariable Long memberId){
        memberService.delete(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
