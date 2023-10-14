package wanted.pre.onboardingbackend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

    @Query("select new wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse$ListDTO(r, c) " +
            "from Recruitment r " +
            "join fetch r.company c ")
    List<RecruitmentResponse.ListDTO> findRecruitments();

    @Query("select new wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse$ListDTO(r, c) " +
            "from Recruitment r " +
            "join fetch r.company c " +
            "where c.name like concat('%', :search, '%') " +
            "or r.position like concat('%', :search, '%') " +
            "or r.content like concat('%', :search, '%') " +
            "or r.techStack like concat('%', :search, '%')")
    List<RecruitmentResponse.ListDTO> searchRecruitments(@Param("search") String search);
}
