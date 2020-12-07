package own.development.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "hero")
@Table(name = "hero", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@Data
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hero_id")
    private Long hero_id;

    @Column(name = "name", unique = true)
    private String name;
}