package demo.kogas.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Project(){
    }

    public Project(String title, String name,Type type) {
        this.title = title;
        this.name = name;
        this.type = type;
    }
}
