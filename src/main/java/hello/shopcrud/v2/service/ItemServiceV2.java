package hello.shopcrud.v2.service;

import hello.shopcrud.v2.dto.ItemDtoV2;
import hello.shopcrud.v2.dto.ItemMapperV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceV2 {

    private final ItemMapperV2 itemMapperV2;

    public List<ItemDtoV2> itemAllList(){
        List<ItemDtoV2> findAll = itemMapperV2.itemListFindAll();
        log.info("아이템 전체 조회 서비스 들렀다감 ㅅㄱ링~");
        return findAll;
    }
}
