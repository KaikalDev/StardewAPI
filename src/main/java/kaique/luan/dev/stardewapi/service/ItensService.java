package kaique.luan.dev.stardewapi.service;

import kaique.luan.dev.stardewapi.domain.models.Item;
import kaique.luan.dev.stardewapi.domain.repository.ItensRepository;
import kaique.luan.dev.stardewapi.service.intefaces.IItensService;
import org.springframework.beans.BeanUtils;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
>>>>>>> f9f3d116153838ebeae76e966abee2246afb30fd

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

<<<<<<< HEAD
@Service
=======
>>>>>>> f9f3d116153838ebeae76e966abee2246afb30fd
public class ItensService implements IItensService {

    private final ItensRepository itensRepository;

    public ItensService(ItensRepository itensRepository) {
        this.itensRepository = itensRepository;
    }

    @Override
    public Item addItem(Item item) {
        if (itensRepository.existsByItemId(item.getItemId())) {
            throw new IllegalArgumentException("Item with itemId already exists.");
        }
        return itensRepository.save(item);
    }

    @Override
    public Boolean deleteItem(Item item) {
        Optional<Item> itemOptional = itensRepository.findByItemId(item.getItemId());
        if (itemOptional.isEmpty()) {
            throw new NoSuchElementException("Item not found.");
        }
        itensRepository.delete(itemOptional.get());
        return true;
    }

    @Override
    public Item updateItem(Item item) {
        Item existing = itensRepository.findByItemId(item.getItemId())
                .orElseThrow(() -> new NoSuchElementException("Item not found."));

        BeanUtils.copyProperties(item, existing, "id");

        return itensRepository.save(existing);
    }

    @Override
    public Item getItemByItemId(Long itemId) {
        return itensRepository.findByItemId(itemId)
                .orElseThrow(() -> new NoSuchElementException("Item with itemId " + itemId + " not found."));
    }

    @Override
    public List<Item> getAllItems() {
        return itensRepository.findAll();
    }
}
