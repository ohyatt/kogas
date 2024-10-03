package demo.kogas.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 20)
    private Type type;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    public Project(){
    }

    public Project(String title, String name,Type type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
