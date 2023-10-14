package wanted.pre.onboardingbackend.controller;

import lombok.Getter;
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

    @PostMapping("/recruitments")
    public ResponseDTO addRecruitment(@RequestBody RecruitmentRequest.AddDTO addDTO) {
        recruitmentService.addRecruitment(addDTO);

        return new ResponseDTO<>();
    }

    @PatchMapping("/recruitments/{id}")
    public ResponseDTO updateRecruitment(@PathVariable Long id, @RequestBody RecruitmentRequest.UpdateDTO updateDTO) {
        recruitmentService.updateRecruitment(id, updateDTO);

        return new ResponseDTO<>();
    }

    @DeleteMapping("/recruitments/{id}")
    public ResponseDTO updateRecruitment(@PathVariable Long id) {
        recruitmentService.deleteRecruitment(id);

        return new ResponseDTO<>();
    }

    @GetMapping("/recruitments")
    public ResponseDTO<List<RecruitmentResponse.ListDTO>> getRecruitments(@RequestParam(required = false) String search) {
        if (search.isBlank()) {
            return new ResponseDTO<>(recruitmentService.getRecruitments());
        } else {
            return new ResponseDTO<>(recruitmentService.searchRecruitments(search));
        }
    }

    @GetMapping("/recruitments/{id}")
    public ResponseDTO<RecruitmentResponse.DetailDTO> getRecruitment(@PathVariable Long id) {
        return new ResponseDTO<>(recruitmentService.getRecruitment(id));
    }
}
