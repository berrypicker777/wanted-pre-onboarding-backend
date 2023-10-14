package wanted.pre.onboardingbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wanted.pre.onboardingbackend.dto.ResponseDTO;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentRequest;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentResponse;
import wanted.pre.onboardingbackend.service.RecruitmentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    /**
     * 채용 공고 등록하기
     */
    @PostMapping("/recruitments")
    public ResponseDTO addRecruitment(@RequestBody RecruitmentRequest.AddDTO addDTO) {
        recruitmentService.addRecruitment(addDTO);

        return new ResponseDTO<>();
    }

    /**
     * 채용 공고 수정하기
     */
    @PatchMapping("/recruitments/{id}")
    public ResponseDTO updateRecruitment(@PathVariable Long id, @RequestBody RecruitmentRequest.UpdateDTO updateDTO) {
        recruitmentService.updateRecruitment(id, updateDTO);

        return new ResponseDTO<>();
    }

    /**
     * 채용 공고 삭제하기
     */
    @DeleteMapping("/recruitments/{id}")
    public ResponseDTO updateRecruitment(@PathVariable Long id) {
        recruitmentService.deleteRecruitment(id);

        return new ResponseDTO<>();
    }

    /**
     * 채용 공고 목록 조회하기, 채용 공고 검색하기
     */
    @GetMapping("/recruitments")
    public ResponseDTO<List<RecruitmentResponse.ListDTO>> getRecruitments(@RequestParam(required = false) String search) {
        if (search.isBlank()) {
            return new ResponseDTO<>(recruitmentService.getRecruitments());
        } else {
            return new ResponseDTO<>(recruitmentService.searchRecruitments(search));
        }
    }

    /**
     * 채용 공고 상세 조회하기
     */
    @GetMapping("/recruitments/{id}")
    public ResponseDTO<RecruitmentResponse.DetailDTO> getRecruitment(@PathVariable Long id) {
        return new ResponseDTO<>(recruitmentService.getRecruitment(id));
    }
}
