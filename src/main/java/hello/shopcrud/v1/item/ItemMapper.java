package hello.shopcrud.v1.item;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    //상품저장
    void save(Item item);
    //상품 조회
    List<Item> findAll();
    //상품 상세 보기
    Item findById(int id);
    //상품 수정
    void update(@Param("itemId") int itemId,@Param("item") Item item);
}
