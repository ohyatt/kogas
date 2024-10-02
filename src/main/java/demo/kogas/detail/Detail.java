package demo.kogas.detail;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="detail_id")
    private Long id;

    @ElementCollection
    @Column(name="proposal")
    private List<String> proposal;


    public Detail() {
    }
}
