package p.whatsinmycloset.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="closets")
@Getter @Setter
public class Closet {

    @Id @GeneratedValue
    @Column(name="closet_id")
    private Long id;

    private String name;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToOne(mappedBy = "closet", fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL)
    private List<Clothes> clothesList = new ArrayList<>();

    // 연관관계 매서드
    public void addclothes(Clothes clothes) {
        clothesList.add(clothes);
        clothes.setCloset(this);
    }
}
