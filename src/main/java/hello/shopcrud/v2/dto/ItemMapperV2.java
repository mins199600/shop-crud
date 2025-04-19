package hello.shopcrud.v2.dto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapperV2 {
    List<ItemDtoV2> itemListFindAll();
}
