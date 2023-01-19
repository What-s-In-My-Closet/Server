package p.whatsinmycloset.domain;

import com.sun.xml.bind.v2.TODO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class Clothes {

    @Id @GeneratedValue
    @Column(name = "clothes_id")
    private Long id;

    private String name;
    private int price;
    private String image;
    private String description;

    @Column(name = "ordered_at")
    private Timestamp orderedAt;

    @Column(name = "deposed_at")
    private Timestamp deposedAt;
//    TODO : deposeAt 의 default 값은 null

    private String purchase;

    @Column(name = "last_dry")
    private Timestamp lastDry;

    private String season;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "closet_id")
    private Closet closet;  //옷장 (양방향)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;      //옷의 종류 (단방향)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="color_id")
    private Color color;    //색상 (단방향)

    @OneToOne(mappedBy = "clothes", fetch = FetchType.LAZY)
    private Depose depose;

}
