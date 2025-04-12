package hello.shopcrud.domain.item;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    //상품저장
    void save(Item item);
    //상품 조회
    List<Item> findAll();
    //상품 상세 보기
    Item findById(int id);
}
