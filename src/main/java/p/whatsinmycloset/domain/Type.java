package p.whatsinmycloset.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "types")
@Getter @Setter
public class Type {

    @Id @GeneratedValue
    @Column(name = "type_id")
    private Long id;

    private String name;
}
