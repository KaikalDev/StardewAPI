package kaique.luan.dev.stardewapi.service.intefaces;

import kaique.luan.dev.stardewapi.domain.models.Item;

import java.util.List;

public interface IItensService {

    Item addItem(Item item);

    Boolean deleteItem(Item item);

    Item updateItem(Item item);

    Item getItemByItemId(String itemId);

    List<Item> getAllItems();

}
