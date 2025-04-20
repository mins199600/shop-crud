package hello.shopcrud.v2.controller;

import hello.shopcrud.v2.dto.ItemDtoV2;
import hello.shopcrud.v2.service.ItemServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller("v2ItemController")
@RequiredArgsConstructor
@Slf4j
public class ItemControllerV2 {

    private final ItemServiceV2 itemServiceV2;

    //상품전체조회
    @GetMapping("/")
    public String itemList(Model model){
        List<ItemDtoV2> itemList = itemServiceV2.itemAllList();
        log.info("상품전체조회 시작 : " + itemList);
        model.addAttribute("itemList", itemList);
        return "intermediate/itemsList";
    }

    //상품단일조회
    @GetMapping("/intermediate/itemDetail/{itemId}")
    public String itemListDetail(@PathVariable int itemId, Model model) {
        ItemDtoV2 itemDtoV2 = itemServiceV2.findByOne(itemId);
        model.addAttribute("itemDetail", itemDtoV2);
        log.info(itemDtoV2.toString());
        return "intermediate/itemDetail";
    }
}
