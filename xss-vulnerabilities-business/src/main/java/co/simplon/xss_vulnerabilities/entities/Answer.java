package co.simplon.xss_vulnerabilities.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_responses")
public class Answer {

    public Answer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_response")
    private Long id;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "response")
    String answer;

    public Long getId() {
	return id;
    }

    public String getFirstname() {
	    return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getAnswer() {
	return answer;
    }

    public void setAnswer(String answer) {
	    this.answer = answer;
    }

    @Override
    public String toString() {
	return "Answer [id=" + id + ", firstname=" + firstname + ", response=" + answer + "]";
    }

}
