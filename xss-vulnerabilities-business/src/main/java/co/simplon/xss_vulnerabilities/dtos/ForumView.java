package co.simplon.xss_vulnerabilities.dtos;

import java.util.List;

import co.simplon.xss_vulnerabilities.entities.Answer;

public class ForumView {
    private InstructionView instruction;
    private List<AnswersView> answers;

    public ForumView(InstructionView instruction, List<AnswersView> answers) {
        this.instruction = instruction;
        this.answers = answers;
    }

    public InstructionView getInstruction(Long id) {
	return instruction;
    }

    public void setInstruction(InstructionView instruction) {
	this.instruction = instruction;
    }

    public List<AnswersView> getResponse() {
	return answers;
    }

    public void setResponse(List<AnswersView> answers) {
	this.answers = answers;
    }

}
