package wanted.pre.onboardingbackend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

    @Query("select new wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse$ListDTO(r, c) " +
            "from Recruitment r " +
            "join fetch r.company c ")
    public List<RecruitmentResponse.ListDTO> findRecruitments();
}
