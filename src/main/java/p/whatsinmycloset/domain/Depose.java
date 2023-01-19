package p.whatsinmycloset.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class Depose {

    @Id @GeneratedValue
    @Column(name = "depose_id")
    private Long id;

    private String reason;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;


    // 연관관계 메소드
    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
        clothes.setDepose(this);
        clothes.setDeposedAt(this.createdAt);
    }
}
