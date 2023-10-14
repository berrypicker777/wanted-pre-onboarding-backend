package wanted.pre.onboardingbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wanted.pre.onboardingbackend.dto.ResponseDTO;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentRequest;
import wanted.pre.onboardingbackend.service.RecruitmentService;

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

    @DeleteMapping("/recruitements/{id}")
    public ResponseDTO updateRecruitment(@PathVariable Long id) {
        recruitmentService.deleteRecruitment(id);

        return new ResponseDTO<>();
    }
}
