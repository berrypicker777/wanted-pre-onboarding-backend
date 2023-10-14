package wanted.pre.onboardingbackend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("select count(*) " +
            "from History h " +
            "where h.user.id = :userId")
    int countByUserId(@Param("userId") Long id);
}
