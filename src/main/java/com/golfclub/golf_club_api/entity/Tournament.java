package com.golfclub.golf_club_api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private double cashPrizeAmount;

    @ManyToMany
    @JoinTable(
            name = "tournament_members",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> participatingMembers = new HashSet<>();
    public Tournament() {}

    public Tournament(LocalDate startDate, LocalDate endDate, String location, double entryFee, double cashPrizeAmount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) { this.startDate = startDate;}
    public LocalDate getEndDate() { return endDate;}
    public void setEndDate(LocalDate endDate) { this.endDate = endDate;}
    public String getLocation() { return location;}
    public void setLocation(String location) { this.location = location;}
    public double getEntryFee() { return entryFee;}
    public void setEntryFee(double entryFee) { this.entryFee = entryFee;}
    public double getCashPrizeAmount() { return cashPrizeAmount;}
    public void setCashPrizeAmount(double cashPrizeAmount) { this.cashPrizeAmount = cashPrizeAmount;}
    public Set<Member> getParticipatingMembers() { return participatingMembers;}
    public void setParticipatingMembers(Set<Member> participatingMembers) { this.participatingMembers = participatingMembers;}

    public void addMember(Member member) {
        this.participatingMembers.add(member);
    }
}
