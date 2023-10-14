package wanted.pre.onboardingbackend.dto.application;

import lombok.Getter;
import lombok.Setter;
import wanted.pre.onboardingbackend.model.Company;
import wanted.pre.onboardingbackend.model.History;
import wanted.pre.onboardingbackend.model.Recruitment;

public class ApplicationRequest {

    @Getter
    @Setter
    public static class AddDTO {

        private Long recruitmentId; // 채용 공고 식별자

        private Long userId; // 사용자 식별자

    }
}
