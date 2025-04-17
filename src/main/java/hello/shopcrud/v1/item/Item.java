package hello.shopcrud.v1.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private int id;    //상품번호
    private String itemName;    //상품이름
    private int price;      //상품가격
    private int quantity;   //상품수량 >> integer을 쓴 이유는 수량이 없을수도 있기 때문이다


    public Item() {

    }

    public Item(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
