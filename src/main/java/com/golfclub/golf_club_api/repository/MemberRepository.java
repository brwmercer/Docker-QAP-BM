package com.golfclub.golf_club_api.repository;

import com.golfclub.golf_club_api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByMemberNameContainingIgnoreCase(String memberName);
    List<Member> findByMemberPhoneNumber(String memberPhoneNumber);
    List<Member> findByStartDateOfMembership(LocalDate startDateOfMembership);
}
