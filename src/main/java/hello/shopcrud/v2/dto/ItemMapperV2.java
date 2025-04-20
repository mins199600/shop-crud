package hello.shopcrud.v2.dto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapperV2 {
    //전체조회
    List<ItemDtoV2> itemListFindAll();
    //상품상세조회
    ItemDtoV2 findByOne(int itemId);
}
