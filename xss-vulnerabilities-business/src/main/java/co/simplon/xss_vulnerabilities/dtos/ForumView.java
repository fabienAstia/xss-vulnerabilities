package co.simplon.xss_vulnerabilities.dtos;

import java.util.List;

public class ForumView {
    private InstructionView instruction;
    private List<AnswersView> answers;

    public ForumView(InstructionView instruction, List<AnswersView> answers) {
        this.instruction = instruction;
        this.answers = answers;
    }

    public InstructionView getInstruction() {
	return instruction;
    }

    public void setInstruction(InstructionView instruction) {
	this.instruction = instruction;
    }

    public List<AnswersView> getAnswers() {
	return answers;
    }

    public void setAnswers(List<AnswersView> answers) {
	this.answers = answers;
    }

}
