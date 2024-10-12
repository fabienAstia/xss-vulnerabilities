package co.simplon.xss_vulnerabilities.dtos;

import java.util.List;

import co.simplon.xss_vulnerabilities.entities.Instruction;
import co.simplon.xss_vulnerabilities.entities.Response;

public class ForumView {
    private Instruction instruction;
    private List<Response> response;

    public ForumView(Instruction instruction, List<Response> response) {
	this.instruction = instruction;
	this.response = response;
    }

    public Instruction getInstruction() {
	return instruction;
    }

    public void setInstruction(Instruction instruction) {
	this.instruction = instruction;
    }

    public List<Response> getResponse() {
	return response;
    }

    public void setResponse(List<Response> response) {
	this.response = response;
    }

}
