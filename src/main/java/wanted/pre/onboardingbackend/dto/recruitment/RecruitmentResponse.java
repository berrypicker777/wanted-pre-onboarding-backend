package wanted.pre.onboardingbackend.dto.recruitment;

import lombok.Getter;
import lombok.Setter;
import wanted.pre.onboardingbackend.model.Company;
import wanted.pre.onboardingbackend.model.Recruitment;

import java.util.List;

public class RecruitmentResponse {

    @Getter
    @Setter
    public static class ListDTO {

        private Long recruitmentId;

        private String companyName;

        private String nation;

        private String legion;

        private String position;

        private Integer signingBonus;

        private String techStack;

        public ListDTO(Recruitment recruitment, Company company) {
            this.recruitmentId = recruitment.getId();
            this.companyName = company.getName();
            this.nation = company.getNation();
            this.legion = company.getLegion();
            this.position = recruitment.getPosition();
            this.signingBonus = recruitment.getSigningBonus();
            this.techStack = recruitment.getTechStack();
        }
    }

    @Getter
    @Setter
    public static class DetailDTO {

        private Long recruitmentId;

        private String companyName;

        private String nation;

        private String legion;

        private String position;

        private Integer signingBonus;

        private String techStack;

        private String content;

        private List<Long> idList;

        public DetailDTO(Recruitment recruitment, Company company, List<Long> idList) {
            this.recruitmentId = recruitment.getId();
            this.companyName = company.getName();
            this.nation = company.getNation();
            this.legion = company.getLegion();
            this.position = recruitment.getPosition();
            this.signingBonus = recruitment.getSigningBonus();
            this.techStack = recruitment.getTechStack();
            this.content = recruitment.getContent();
            this.idList = idList;
        }
    }
}
