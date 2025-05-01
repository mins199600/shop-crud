package hello.shopcrud.v2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ItemDtoV2 {

    private int id;
    private String itemName;
    private int price;
    private int quantity;

    public ItemDtoV2() {

    }

    public ItemDtoV2(int id, String itemName, int price, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
