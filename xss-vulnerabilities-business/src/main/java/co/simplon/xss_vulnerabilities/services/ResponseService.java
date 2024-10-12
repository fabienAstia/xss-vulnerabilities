package co.simplon.xss_vulnerabilities.services;

import java.util.Collections;
import java.util.Comparator;
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
	List<Response> response = repository.findAllProjectedBy();
	Collections.sort(response, Comparator.comparing(Response::getId).reversed());

	return response;
    }

    public Response createResponse(ResponseCreate inputResponseDto) {
	Response response = new Response();
	response.setFirstname(inputResponseDto.firstname());
	response.setResponse(inputResponseDto.response());
	return repository.save(response);
    }

}
