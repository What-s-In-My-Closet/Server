package p.whatsinmycloset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.whatsinmycloset.domain.Closet;
import p.whatsinmycloset.domain.Clothes;
import p.whatsinmycloset.domain.Type;
import p.whatsinmycloset.repository.ClothesRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;

    /**
     * 옷 등록
     */
    @Transactional // 변경
    public Long saveClothes(Clothes clothes) {
        clothesRepository.save(clothes);
        return clothes.getId();
    }

    /**
     * TODO : 정렬 순서 (최근 등록순, 오래된 순, 이름순, 가격순) 적용하기
     */
    public List<Clothes> findAllClothes() {
        return clothesRepository.findAll();
    }

    public Clothes findOne(Long id) {
        return clothesRepository.findOne(id);
    }

    /**
     * 카테고리별 옷 조회
     */
    public List<Clothes> findByCollection(Type type) {
        return clothesRepository.findByCollection(type);
    }

    /**
     * 옷장으로 옷 조회
     */
    public List<Clothes> findClothesByCloset(Closet closet) {
        return clothesRepository.findByCloset(closet);
    }

}
