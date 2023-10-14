package wanted.pre.onboardingbackend.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentRequest;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse;
import wanted.pre.onboardingbackend.dummy.MockDummyEntity;
import wanted.pre.onboardingbackend.model.Company;
import wanted.pre.onboardingbackend.model.CompanyRepository;
import wanted.pre.onboardingbackend.model.Recruitment;
import wanted.pre.onboardingbackend.model.RecruitmentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class RecruitmentServiceTest extends MockDummyEntity {

    @InjectMocks
    private RecruitmentService recruitmentService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private RecruitmentRepository recruitmentRepository;

    @DisplayName("채용 공고 등록하기")
    @Test
    void addRecruitment() {

        // given
        Long id = 1L;
        Company company = newMockCompany(id);
        Recruitment recruitment = newMockRecruitment(id, company);
        RecruitmentRequest.AddDTO addDTO = new RecruitmentRequest.AddDTO();
        addDTO.setCompanyId(company.getId());
        addDTO.setPosition(recruitment.getPosition());
        addDTO.setSigningBonus(recruitment.getSigningBonus());
        addDTO.setContent(recruitment.getContent());
        addDTO.setTechStack(recruitment.getTechStack());

        // stub
        when(companyRepository.findById(anyLong())).thenReturn(Optional.of(company));
        when(recruitmentRepository.save(any())).thenReturn(recruitment);

        // when
//        Recruitment result = recruitmentService.addRecruitment(addDTO);

        // then
//        assertThat(result.getCompany().getId()).isEqualTo(1L);
//        assertThat(result.getSigningBonus()).isEqualTo(1500000);
//        assertThat(result.getTechStack()).isEqualTo("Java");
    }

    @DisplayName("채용 공고 수정하기")
    @Test
    void updateRecruitment() {

        // given
        Long id = 1L;
        Company company = newMockCompany(id);
        Recruitment recruitment = newMockRecruitment(id, company);
        RecruitmentRequest.UpdateDTO updateDTO = new RecruitmentRequest.UpdateDTO();
        updateDTO.setPosition("포지션 수정");
        updateDTO.setSigningBonus(500000);
        updateDTO.setContent("내용 수정");
        updateDTO.setTechStack("기술 수정");

        // stub
        when(recruitmentRepository.findById(anyLong())).thenReturn(Optional.of(recruitment));

        // when
        recruitmentService.updateRecruitment(id, updateDTO);

        // then

    }

    @DisplayName("채용 공고 삭제하기")
    @Test
    void deleteRecruitment() {

        // given
        Long id = 1L;
        Company company = newMockCompany(id);
        Recruitment recruitment = newMockRecruitment(id, company);

        // stub
        when(recruitmentRepository.findById(anyLong())).thenReturn(Optional.of(recruitment));
        doNothing().when(recruitmentRepository).deleteById(anyLong());

        // when
        recruitmentService.deleteRecruitment(id);

        // then

    }

    @DisplayName("채용 공고 목록 조회하기")
    @Test
    void getRecruitments() {

        // given
        Long id = 1L;
        Long id2 = 2L;
        Company company = newMockCompany(id);
        Recruitment recruitment = newMockRecruitment(id, company);
        Recruitment recruitment2 = newMockRecruitment(id2, company);
        List<RecruitmentResponse.ListDTO> list = new ArrayList<>();
        RecruitmentResponse.ListDTO listDTO = new RecruitmentResponse.ListDTO(
                recruitment, company
        );
        RecruitmentResponse.ListDTO listDTO2 = new RecruitmentResponse.ListDTO(
                recruitment2, company
        );
        list.add(listDTO);
        list.add(listDTO2);

        // stub
        when(recruitmentRepository.findRecruitments()).thenReturn(list);

        // when
        List<RecruitmentResponse.ListDTO> result = recruitmentService.getRecruitments();

        // then
        assertThat(result.get(0).getRecruitmentId()).isEqualTo(1L);
        assertThat(result.get(1).getRecruitmentId()).isEqualTo(2L);
    }

    @DisplayName("채용 공고 검색하기")
    @Test
    void searchRecruitments() {

        // given
        String search = "원티드";
        Long id = 1L;
        Long id2 = 2L;
        Company company = newMockCompany(id);
        Recruitment recruitment = newMockRecruitment(id, company);
        Recruitment recruitment2 = newMockRecruitment(id2, company);
        List<RecruitmentResponse.ListDTO> list = new ArrayList<>();
        RecruitmentResponse.ListDTO listDTO = new RecruitmentResponse.ListDTO(
                recruitment, company
        );
        RecruitmentResponse.ListDTO listDTO2 = new RecruitmentResponse.ListDTO(
                recruitment2, company
        );
        list.add(listDTO);
        list.add(listDTO2);

        // stub
        when(recruitmentRepository.searchRecruitments(any())).thenReturn(list);

        // when
        List<RecruitmentResponse.ListDTO> result = recruitmentService.searchRecruitments(search);

        // then
        assertThat(result.get(0).getRecruitmentId()).isEqualTo(1L);
        assertThat(result.get(0).getCompanyName()).contains("원티드");
        assertThat(result.get(1).getRecruitmentId()).isEqualTo(2L);
        assertThat(result.get(1).getCompanyName()).contains("원티드");
    }

    @DisplayName("채용 공고 상세 조회하기")
    @Test
    void getRecruitment() {

        // given
        Long id = 1L;
        Company company = newMockCompany(id);
        Recruitment recruitment = newMockRecruitment(id, company);
        ArrayList<Long> idList = new ArrayList<>(Arrays.asList(3L, 4L));
        RecruitmentResponse.DetailDTO detailDTO = new RecruitmentResponse.DetailDTO(
                recruitment, company, idList
        );

        // stub
        when(recruitmentRepository.findById(anyLong())).thenReturn(Optional.of(recruitment));
        when(companyRepository.findById(anyLong())).thenReturn(Optional.of(company));
        when(recruitmentRepository.findByCompanyId(anyLong())).thenReturn(idList);

        // when
        RecruitmentResponse.DetailDTO result = recruitmentService.getRecruitment(id);

        // then
        assertThat(result.getRecruitmentId()).isEqualTo(1L);
        assertThat(result.getCompanyName()).isEqualTo("원티드랩");
        assertThat(result.getIdList().get(0)).isEqualTo(3L);
    }
}