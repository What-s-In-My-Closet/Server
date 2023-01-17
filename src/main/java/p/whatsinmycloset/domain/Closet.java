package p.whatsinmycloset.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="closets")
@Getter @Setter
public class Closet {

    @Id @GeneratedValue
    @Column(name="closet_id")
    private Long id;

    private String name;
    private Timestamp created_at;

    @OneToOne(mappedBy = "closet", fetch = FetchType.LAZY)
    private User user;
}
