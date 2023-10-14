package wanted.pre.onboardingbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.pre.onboardingbackend.core.exception.Exception404;
import wanted.pre.onboardingbackend.core.exception.Exception500;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentRequest;
import wanted.pre.onboardingbackend.model.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final HistoryRepository historyRepository;

    public void addRecruitment(RecruitmentRequest.AddDTO addDTO) {
        Company companyPS = companyRepository.findById(addDTO.getCompanyId()).orElseThrow(
                () -> new Exception404("해당 회사가 존재하지 않습니다.")
        );

        try {
            recruitmentRepository.save(addDTO.toEntity(companyPS));
        } catch (Exception e) {
            throw new Exception500(e.getMessage());
        }
    }

}
