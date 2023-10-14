package wanted.pre.onboardingbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.pre.onboardingbackend.core.exception.Exception400;
import wanted.pre.onboardingbackend.core.exception.Exception404;
import wanted.pre.onboardingbackend.dto.application.ApplicationRequest;
import wanted.pre.onboardingbackend.model.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ApplicationService {

    private final RecruitmentRepository recruitmentRepository;
    private final UserRepository userRepository;
    private final HistoryRepository historyRepository;

    /**
     * 채용 공고 지원하기
     */
    @Transactional
    public void addApplication(ApplicationRequest.AddDTO addDTO) {
        User userPS = userRepository.findById(addDTO.getUserId()).orElseThrow(
                () -> new Exception404("해당 사용자가 존재하지 않습니다.")
        );

        Recruitment recruitmentPS = recruitmentRepository.findById(addDTO.getRecruitmentId()).orElseThrow(
                () -> new Exception404("해당 채용 공고가 존재하지 않습니다.")
        );

        if (historyRepository.countByUserId(userPS.getId()) == 0) {
            historyRepository.save(
                    History.builder()
                            .user(userPS)
                            .recruitment(recruitmentPS)
                            .build()
            );
        } else {
            throw new Exception400("사용자 식별자: " + addDTO.getUserId(), "중복해서 지원할 수 없습니다.");
        }
    }
}