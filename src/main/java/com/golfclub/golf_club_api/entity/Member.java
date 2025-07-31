package com.golfclub.golf_club_api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberName;
    private String memberAddress;
    private String memberEmailAddress;
    private String memberPhoneNumber;
    private LocalDate startDateOfMembership;
    private int durationOfMembership;

    public Member() {}

    public Member(String memberName, String memberAddress, String memberEmailAddress, String memberPhoneNumber, LocalDate startDateOfMembership, int durationOfMembership) {
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberPhoneNumber = memberPhoneNumber;
        this.startDateOfMembership = startDateOfMembership;
        this.durationOfMembership = durationOfMembership;
    }

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}
    public String getMemberName() { return memberName;}
    public void setMemberName(String memberName) { this.memberName = memberName;}
    public String getMemberAddress() { return memberAddress;}
    public void setMemberAddress(String memberAddress) { this.memberAddress = memberAddress;}
    public String getMemberEmailAddress() { return memberEmailAddress;}
    public void setMemberEmailAddress(String memberEmailAddress) { this.memberEmailAddress = memberEmailAddress;}
    public String getMemberPhoneNumber() { return memberPhoneNumber;}
    public void setMemberPhoneNumber(String memberPhoneNumber) { this.memberPhoneNumber = memberPhoneNumber;}
    public LocalDate getStartDateOfMembership() { return startDateOfMembership;}
    public void setStartDateOfMembership(LocalDate startDateOfMembership) { this.startDateOfMembership = startDateOfMembership;}
    public int getDurationOfMembership() { return durationOfMembership;}
    public void setDurationOfMembership(int durationOfMembership) { this.durationOfMembership = durationOfMembership;}
}
