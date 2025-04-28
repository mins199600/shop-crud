package hello.shopcrud.v2.dto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapperV2 {
    //전체조회
    List<ItemDtoV2> itemListFindAll();

    //상품상세조회
    ItemDtoV2 findByOne(int itemId);

    //상품수정
    void updateItem (ItemDtoV2 itemDtoV2);

    //상품등록
    void insertItem(ItemDtoV2 itemAdd);
    void reorderAfterInsert(ItemDtoV2 item);

    //상품삭제
    void removeItem(int id);
    void reorderItems();


}

