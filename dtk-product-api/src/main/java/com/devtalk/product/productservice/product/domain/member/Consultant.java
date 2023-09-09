package com.devtalk.product.productservice.product.domain.member;

import com.devtalk.product.productservice.product.application.port.in.dto.ConsultantPrivacyReq;
import com.devtalk.product.productservice.product.domain.product.ReservedProceedType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("CONSULTANT")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder // 👈 여기 추가
public class Consultant extends Member {

    private int NF2F_Price;

    private int F2F_Price;

    private String region;

//    public static Consultant createConsulter(Long memberId, String loginId, String name, MemberType memberType,
//                                             int NF2F, int F2F, String region) {
//        return Consultant.builder()
//                .id(memberId)
//                .loginId(loginId)
//                .name(name)
//                .memberType(memberType)
//                .NF2F(NF2F)
//                .F2F(F2F)
//                .region(region)
//                .build();
//    }
    public int getPrice(ReservedProceedType reservedProceedType) {
        if (reservedProceedType == ReservedProceedType.NF2F) {
            return this.NF2F_Price;
        }
        if (reservedProceedType == ReservedProceedType.F2F){
            return this.F2F_Price;
        }
        else
            return 0;
    }

    public Consultant updatePrivacy(ConsultantPrivacyReq consultantPrivacyReq){
        return   Consultant.builder()
                .NF2F_Price(consultantPrivacyReq.getNF2F_Price())
                .F2F_Price(consultantPrivacyReq.getF2F_Price())
                .region(consultantPrivacyReq.getRegion())
                .build();
    }

}

