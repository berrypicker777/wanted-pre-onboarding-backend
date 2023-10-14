package wanted.pre.onboardingbackend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "recruitment_tb")
@Entity
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company; // 회사

    @Column(nullable = false, length = 30)
    private String position; // 채용 포지션

    @Column(nullable = false)
    private Integer signingBonus; // 채용 보상금

    @Column(nullable = false, length = 20)
    private String techStack; // 사용 기술

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 채용 내용, 내용이 길어질 수 있으므로 varchar이 아닌 text 사용

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
