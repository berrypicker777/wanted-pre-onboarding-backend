package wanted.pre.onboardingbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.pre.onboardingbackend.model.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final HistoryRepository historyRepository;


}
