package wanted.pre.onboardingbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wanted.pre.onboardingbackend.dto.ResponseDTO;
import wanted.pre.onboardingbackend.dto.application.ApplicationRequest;
import wanted.pre.onboardingbackend.service.ApplicationService;

@RequiredArgsConstructor
@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    /**
     * 채용 공고 지원하기
     */
    @PostMapping("/application")
    public ResponseDTO addApplication(@RequestBody ApplicationRequest.AddDTO addDTO) {
        applicationService.addApplication(addDTO);

        return new ResponseDTO<>();
    }
}
