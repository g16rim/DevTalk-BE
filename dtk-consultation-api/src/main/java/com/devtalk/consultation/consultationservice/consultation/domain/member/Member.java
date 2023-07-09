package com.devtalk.consultation.consultationservice.consultation.domain.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String loginId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    @Enumerated(value = EnumType.STRING)
    private RoleType role;

    Member(Long id, String loginId, String name, RoleType role) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.role = role;
    }
}
