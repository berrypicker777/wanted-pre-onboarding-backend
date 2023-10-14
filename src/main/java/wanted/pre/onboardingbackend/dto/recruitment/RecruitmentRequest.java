package wanted.pre.onboardingbackend.dto.recruitment;

import lombok.Getter;
import lombok.Setter;

public class RecruitmentRequest {

    @Getter
    @Setter
    public static class AddDTO {

        private Long companyId; // 회사 식별자

        private String position; // 채용 포지션

        private Integer signingBonus; // 채용 보상금

        private String content; // 채용 내용

        private String techStack; // 사용 기술

        public AddDTO(Long companyId, String position, Integer signingBonus, String content, String techStack) {
            this.companyId = companyId;
            this.position = position;
            this.signingBonus = signingBonus;
            this.content = content;
            this.techStack = techStack;
        }
    }

    @Getter
    @Setter
    public static class UpdateDTO {

        private String position; // 채용 포지션

        private Integer signingBonus; // 채용 보상금

        private String content; // 채용 내용

        private String techStack; // 사용 기술

        public UpdateDTO(String position, Integer signingBonus, String content, String techStack) {
            this.position = position;
            this.signingBonus = signingBonus;
            this.content = content;
            this.techStack = techStack;
        }
    }
}
