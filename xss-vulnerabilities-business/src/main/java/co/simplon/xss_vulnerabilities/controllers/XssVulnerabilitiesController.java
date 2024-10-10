package co.simplon.xss_vulnerabilities.controllers;

import co.simplon.xss_vulnerabilities.dtos.InputResponseDto;
import co.simplon.xss_vulnerabilities.entities.Response;
import co.simplon.xss_vulnerabilities.services.ResponseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xss")
public class XssVulnerabilitiesController {

    private final ResponseService responseService;

    public XssVulnerabilitiesController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }

    @PutMapping
    public Response createResponse(InputResponseDto inputResponseDto){
        return responseService.createResponse(inputResponseDto);
    }
}
