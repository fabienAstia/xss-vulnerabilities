package co.simplon.xss_vulnerabilities.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.xss_vulnerabilities.dtos.ResponseCreate;
import co.simplon.xss_vulnerabilities.entities.Response;
import co.simplon.xss_vulnerabilities.repositories.ResponseRepository;

@Service
public class ResponseService {

    private final ResponseRepository repository;

    public ResponseService(ResponseRepository responseRepository) {
	this.repository = responseRepository;
    }

    public List<Response> getAllResponses() {
	return repository.findAllProjectedBy();
    }

    public Response createResponse(ResponseCreate inputResponseDto) {
	Response response = new Response();
	response.setFirstname(inputResponseDto.firstname());
	response.setResult(inputResponseDto.response());
	return repository.save(response);
    }

}
