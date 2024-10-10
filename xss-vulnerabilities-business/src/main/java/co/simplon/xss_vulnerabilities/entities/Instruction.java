package co.simplon.xss_vulnerabilities.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_instructions")
public class Instruction {

    public Instruction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instruction")
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
