package wanted.pre.onboardingbackend.dto.recruitment;

import lombok.Getter;
import lombok.Setter;
import wanted.pre.onboardingbackend.model.Company;
import wanted.pre.onboardingbackend.model.Recruitment;

public class RecruitmentRequest {

    @Getter
    @Setter
    public static class AddDTO {

        private Long companyId; // 회사 식별자

        private String position; // 채용 포지션

        private Integer signingBonus; // 채용 보상금

        private String content; // 채용 내용

        private String techStack; // 사용 기술

        public Recruitment toEntity(Company company) {
            return Recruitment.builder()
                    .company(company)
                    .position(position)
                    .signingBonus(signingBonus)
                    .content(content)
                    .techStack(techStack)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class UpdateDTO {

        private String position; // 채용 포지션

        private Integer signingBonus; // 채용 보상금

        private String content; // 채용 내용

        private String techStack; // 사용 기술

    }
}
