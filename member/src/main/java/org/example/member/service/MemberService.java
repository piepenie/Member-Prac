package org.example.member.service;

import lombok.RequiredArgsConstructor;
import org.example.member.dto.*;
import org.example.member.entity.Member;
import org.example.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse save(CreateMemberRequest request) {
        Member member = new Member(
                request.getName(),
                request.getEmail(),
                request.getAddress()
        );

        Member saveMember = memberRepository.save(member);
        return new CreateMemberResponse(
                saveMember.getId(),
                saveMember.getName(),
                saveMember.getEmail(),
                saveMember.getAddress()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMemberResponse> getALL() {
        List<Member> members = memberRepository.findAll();
        List<GetMemberResponse> dtos = new ArrayList<>();

        for (Member member : members) {
            GetMemberResponse dto = new GetMemberResponse(
                    member.getId(),
                    member.getName(),
                    member.getEmail(),
                    member.getAddress()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetMemberResponse getOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 멤버입니다.")
        );
        return new GetMemberResponse(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getAddress()
        );
    }

    @Transactional
    public UpdateMemberResponse update(Long memberId, UpdateMemberRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 멤버입니다.")
        );
        member.update(
                request.getName(),
                request.getEmail(),
                request.getAddress()
        );
        return new UpdateMemberResponse(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getAddress()
        );
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 멤버입니다.");
        }

        memberRepository.deleteById(memberId);
    }
}
