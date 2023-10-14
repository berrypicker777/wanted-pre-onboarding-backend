package wanted.pre.onboardingbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wanted.pre.onboardingbackend.dto.ResponseDTO;
import wanted.pre.onboardingbackend.dto.recruitment.RecruitmentRequest;
import wanted.pre.onboardingbackend.service.RecruitmentService;

@RequiredArgsConstructor
@RestController
public class RecruitmentController {
    private final RecruitmentService recruitmentService;

    @PostMapping("/company/{companyId}/recruitment")
    public ResponseDTO addRecruitment(@PathVariable Long companyId, @RequestBody RecruitmentRequest.AddDTO addDTO) {
        recruitmentService.addRecruitment(companyId, addDTO);

        return new ResponseDTO<>();
    }
}
