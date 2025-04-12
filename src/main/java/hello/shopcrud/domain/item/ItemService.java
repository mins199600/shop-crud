package hello.shopcrud.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper ItemMapper;

    //상품저장
    public void saveItem(Item item) {
        ItemMapper.save(item);
    }

}
