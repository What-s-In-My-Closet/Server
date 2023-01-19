package p.whatsinmycloset.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="colors")
@Getter @Setter
public class Color {

    @Id @GeneratedValue
    @Column(name="color_id")
    private Long id;

    private String name;
}
