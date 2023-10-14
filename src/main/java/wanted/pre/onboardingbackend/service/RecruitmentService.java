package wanted.pre.onboardingbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.pre.onboardingbackend.core.exception.Exception404;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentRequest;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse;
import wanted.pre.onboardingbackend.model.*;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final HistoryRepository historyRepository;

    @Transactional
    public void addRecruitment(RecruitmentRequest.AddDTO addDTO) {
        Company companyPS = companyRepository.findById(addDTO.getCompanyId()).orElseThrow(
                () -> new Exception404("해당 회사가 존재하지 않습니다.")
        );

        recruitmentRepository.save(addDTO.toEntity(companyPS));
    }

    @Transactional
    public void updateRecruitment(Long id, RecruitmentRequest.UpdateDTO updateDTO) {
        Recruitment recruitmentPS = recruitmentRepository.findById(id).orElseThrow(
                () -> new Exception404("해당 채용공고가 존재하지 않습니다.")
        );

        recruitmentPS.update(updateDTO);
    }

    @Transactional
    public void deleteRecruitment(Long id) {
        recruitmentRepository.findById(id).orElseThrow(
                () -> new Exception404("해당 채용공고가 존재하지 않습니다.")
        );

        recruitmentRepository.deleteById(id);
    }

    public List<RecruitmentResponse.ListDTO> getRecruitments() {
        return recruitmentRepository.findRecruitments();
    }

    public List<RecruitmentResponse.ListDTO> searchRecruitments(String search) {
        return recruitmentRepository.searchRecruitments(search);
    }

    public RecruitmentResponse.DetailDTO getRecruitment(Long id) {
        Recruitment recruitmentPS = recruitmentRepository.findById(id).orElseThrow(
                () -> new Exception404("해당 채용공고가 존재하지 않습니다.")
        );

        Company companyPS = companyRepository.findById(recruitmentPS.getCompany().getId()).orElseThrow(
                () -> new Exception404("해당 회사가 존재하지 않습니다.")
        );

        List<Long> recruitmentIdList = recruitmentRepository.findByCompanyId(companyPS.getId());

        return new RecruitmentResponse.DetailDTO(recruitmentPS, companyPS, recruitmentIdList);
    }
}
