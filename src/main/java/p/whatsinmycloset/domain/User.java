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
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "closet_id")
    private Closet closet; // 옷장

    // 연관관계 메소드
    public void setCloset(Closet closet) {
        this.closet = closet;
        closet.setUser(this);
    }
}
