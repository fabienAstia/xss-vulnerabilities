package co.simplon.xss_vulnerabilities.dtos;

import java.util.List;

/**
 * Display all informations
 */
public class AdminView {
    private List<InstructionView> instruction;
    private List<AnswersView> answers;

    public AdminView(List<InstructionView> instruction, List<AnswersView> answers) {
	this.instruction = instruction;
	this.answers = answers;
    }

    public List<InstructionView> getInstruction() {
	return instruction;
    }

    public void setInstruction(List<InstructionView> instruction) {
	this.instruction = instruction;
    }

    public List<AnswersView> getAnswers() {
	return answers;
    }

    public void setAnswers(List<AnswersView> answers) {
	this.answers = answers;
    }

}
