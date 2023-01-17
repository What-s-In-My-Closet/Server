package p.whatsinmycloset.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;
    private String email;
    private String password;
    private Timestamp created_at;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "closet_id")
    private Closet closet; // 옷장
}
