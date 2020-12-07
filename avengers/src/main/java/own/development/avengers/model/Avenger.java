package own.development.avengers.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "avengers", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@Data
public class Avenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    private Information information;
}
