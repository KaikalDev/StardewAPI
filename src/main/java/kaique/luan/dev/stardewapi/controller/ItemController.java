package kaique.luan.dev.stardewapi.controller;

import kaique.luan.dev.stardewapi.domain.models.Item;
import kaique.luan.dev.stardewapi.service.intefaces.IItensService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final IItensService itensService;

    public ItemController(IItensService itensService) {
        this.itensService = itensService;
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item itemToCreate) {
        var itemCreated = itensService.addItem(itemToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{itemId}")
                .buildAndExpand(itemCreated.getItemId())
                .toUri();
        return ResponseEntity.created(location).body(itemCreated);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemByItemId(@PathVariable Long itemId) {
        var item = itensService.getItemByItemId(itemId);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        var items = itensService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Long itemId, @RequestBody Item itemToUpdate) {
        itemToUpdate.setItemId(itemId);
        var updated = itensService.updateItem(itemToUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        Item toDelete = new Item();
        toDelete.setItemId(itemId);
        itensService.deleteItem(toDelete);
        return ResponseEntity.noContent().build();
    }

}
