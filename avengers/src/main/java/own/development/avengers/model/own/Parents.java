package own.development.avengers.model.own;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
public class Parents {
    @Column(name = "mother")
    private String mother;
    @Column(name = "father")
    private String father;
    @OneToOne(mappedBy = "parents", cascade = CascadeType.ALL)
    private Student student;
}
