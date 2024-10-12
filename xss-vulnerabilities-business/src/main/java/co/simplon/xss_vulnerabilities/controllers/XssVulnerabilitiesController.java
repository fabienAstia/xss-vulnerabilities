package co.simplon.xss_vulnerabilities.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.xss_vulnerabilities.dtos.ResponseCreate;
import co.simplon.xss_vulnerabilities.entities.Response;
import co.simplon.xss_vulnerabilities.services.ResponseService;

@RestController
@RequestMapping("/xss")
public class ResponseController {

    private final ResponseService service;

    public ResponseController(ResponseService service) {
	this.service = service;
    }

    @GetMapping("/comments")
    public List<Response> getAllResponses() {
	return service.getAllResponses();
    }

    @PostMapping
    public Response createResponse(ResponseCreate inputResponseDto) {
	return service.createResponse(inputResponseDto);
    }
}
