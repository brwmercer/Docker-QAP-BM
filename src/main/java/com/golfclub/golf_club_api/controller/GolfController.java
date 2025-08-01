package com.golfclub.golf_club_api.controller;

import com.golfclub.golf_club_api.entity.Member;
import com.golfclub.golf_club_api.entity.Tournament;
import com.golfclub.golf_club_api.repository.MemberRepository;
import com.golfclub.golf_club_api.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GolfController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @PostMapping("/members")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member saved = memberRepository.save(member);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/search")
    public List<Member> searchMembers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) LocalDate startDate
    ) {
        if (name != null) return memberRepository.findByMemberNameContainingIgnoreCase(name);
        if (phone != null) return memberRepository.findByMemberPhoneNumber(phone);
        if (startDate != null) return memberRepository.findByStartDateOfMembership(startDate);
        return memberRepository.findAll();
    }

    @PostMapping("/tournaments")
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        Tournament saved = tournamentRepository.save(tournament);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @GetMapping("/tournaments/search")
    public List<Tournament> searchTournaments(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) String location
    ) {
        if (startDate != null) return tournamentRepository.findByStartDate(startDate);
        if (location != null) return tournamentRepository.findByLocationContainingIgnoreCase(location);
        return tournamentRepository.findAll();
    }

    @PostMapping("/tournaments/{tournamentId}/members/{memberId}")
    public ResponseEntity<Tournament> addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId
    ) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (tournament == null || member == null) {
            return ResponseEntity.notFound().build();
        }

        tournament.addMember(member);
        Tournament saved = tournamentRepository.save(tournament);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/tournaments/{tournamentId}/members")
    public Optional<ArrayList<Member>> getMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .map(tournament -> new ArrayList<>(tournament.getParticipatingMembers()));
    }
}
