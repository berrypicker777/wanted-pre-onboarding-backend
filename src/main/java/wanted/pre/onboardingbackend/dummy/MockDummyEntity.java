package wanted.pre.onboardingbackend.dummy;

import wanted.pre.onboardingbackend.model.Company;
import wanted.pre.onboardingbackend.model.Recruitment;

import java.time.LocalDateTime;

/**
 * 단위 테스트에 사용할 임시 엔티티
 */
public class MockDummyEntity {

    public Company newMockCompany(Long id) {
        return Company.builder()
                .id(id)
                .name("원티드랩")
                .nation("한국")
                .legion("서울")
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Recruitment newMockRecruitment(Long id, Company company) {
        return Recruitment.builder()
                .id(id)
                .company(company)
                .position("백엔드 주니어 개발자")
                .signingBonus(1500000)
                .techStack("Java")
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .createdAt(LocalDateTime.now())
                .build();
    }
}
