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
    private final RecruitmentRepository recruitmentRepository;

    /**
     * 채용 공고 등록하기
     */
    @Transactional
    public void addRecruitment(RecruitmentRequest.AddDTO addDTO) {
        Company companyPS = companyRepository.findById(addDTO.getCompanyId()).orElseThrow(
                () -> new Exception404("해당 회사가 존재하지 않습니다.")
        );

        recruitmentRepository.save(addDTO.toEntity(companyPS));
    }

    /**
     * 채용 공고 수정하기
     */
    @Transactional
    public void updateRecruitment(Long id, RecruitmentRequest.UpdateDTO updateDTO) {
        Recruitment recruitmentPS = recruitmentRepository.findById(id).orElseThrow(
                () -> new Exception404("해당 채용공고가 존재하지 않습니다.")
        );

        recruitmentPS.update(updateDTO);
    }

    /**
     * 채용 공고 삭제하기
     */
    @Transactional
    public void deleteRecruitment(Long id) {
        recruitmentRepository.findById(id).orElseThrow(
                () -> new Exception404("해당 채용공고가 존재하지 않습니다.")
        );

        recruitmentRepository.deleteById(id);
    }

    /**
     * 채용 공고 목록 조회하기
     */
    public List<RecruitmentResponse.ListDTO> getRecruitments() {
        return recruitmentRepository.findRecruitments();
    }

    /**
     * 채용 공고 검색하기
     */
    public List<RecruitmentResponse.ListDTO> searchRecruitments(String search) {
        return recruitmentRepository.searchRecruitments(search);
    }

    /**
     * 채용 공고 상세 조회하기
     */
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
