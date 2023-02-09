package p.whatsinmycloset.repository;

import org.springframework.stereotype.Repository;
import p.whatsinmycloset.domain.Closet;
import p.whatsinmycloset.domain.Clothes;
import p.whatsinmycloset.domain.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClothesRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Clothes clothes) {
        if (clothes.getId() == null) {
            em.persist(clothes);
        } else {
            em.merge(clothes);
        }
    }

    public Clothes findOne(Long id) { return em.find(Clothes.class, id); }

    public List<Clothes> findAll() {

        return em.createQuery("select c from Clothes c", Clothes.class).getResultList();
    }

    // 옷 조회 - collections 으로 조회
    public List<Clothes> findByCollection(Type type) {
        return em.createQuery("select c from Clothes c where c.type = :type", Clothes.class)
                .setParameter("type", type)
                .getResultList();
    }

    // 옷 조회 - closet 으로 조회
    public List<Clothes> findByCloset(Closet closet) {
        return em.createQuery("select c from Clothes c where c.closet = :closet", Clothes.class)
                .setParameter("closet", closet)
                .getResultList();
    }
}

