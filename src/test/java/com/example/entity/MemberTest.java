package com.example.entity;

import com.example.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("Auditing 테스트")
    @WithMockUser(username = "gildong",roles="USER")
    public void auditingTest() {
        Member member = new Member();
        memberRepository.save(member);
        em.flush();
        em.clear();
        Member findMember = memberRepository.findById(member.getId()).orElseThrow(EntityNotFoundException::new);
        System.out.println("register time:" + member.getRegTime());
        System.out.println("update time:" + member.getUpdateTime());
        System.out.println("create time:" + member.getCreatedBy());
        System.out.println("modify time:" + member.getModifiedBy());

    }
}