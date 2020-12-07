package own.development.avengers.model.own;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tuition")
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student")
    private List<Student> students;
}
