package kaique.luan.dev.stardewapi.service;

import kaique.luan.dev.stardewapi.domain.models.Bonus;
import kaique.luan.dev.stardewapi.domain.models.Culinary;
import kaique.luan.dev.stardewapi.domain.models.DTO.CulinaryDTO;
import kaique.luan.dev.stardewapi.domain.models.Ingredient;
import kaique.luan.dev.stardewapi.domain.models.Item;
import kaique.luan.dev.stardewapi.domain.repository.CulinaryRepository;
import kaique.luan.dev.stardewapi.domain.repository.ItensRepository;
import kaique.luan.dev.stardewapi.service.intefaces.ICulinaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CulinaryService implements ICulinaryService {

    private final CulinaryRepository culinaryRepository;
    private final ItensRepository itemRepository;

    public CulinaryService(CulinaryRepository culinaryRepository, ItensRepository itemRepository) {
        this.culinaryRepository = culinaryRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Culinary create(CulinaryDTO dto) {
        Culinary culinaryToAdd = formDTOToCulinary(dto);

        if (culinaryRepository.existsByItem_ItemId(culinaryToAdd.getItem().getItemId())) {
            throw new IllegalArgumentException("This item already exists.");
        }
        return culinaryRepository.save(culinaryToAdd);
    }

    @Override
    public Boolean deleteCulinary(Culinary culinaryToDelete) {
        if (!culinaryRepository.existsById(culinaryToDelete.getId())) {
            throw new NoSuchElementException("Culinary not found.");
        }
        culinaryRepository.deleteById(culinaryToDelete.getId());
        return true;
    }

    @Override
    public Culinary updateCulinary(Culinary culinaryToUpdate) {
        Culinary existing = culinaryRepository.findById(culinaryToUpdate.getId())
                .orElseThrow(() -> new NoSuchElementException("Culinary not found."));

        BeanUtils.copyProperties(culinaryToUpdate, existing, "id");
        return culinaryRepository.save(existing);
    }

    @Override
    public Culinary getCulinaryByItemId(Long itemId) {
        return culinaryRepository.findCulinaryByItem_ItemId(itemId)
                .orElseThrow(() -> new NoSuchElementException("Culinary with itemId " + itemId + " not found."));
    }

    @Override
    public List<Culinary> getAllCulinarys() {
        return culinaryRepository.findAll();
    }

    @Override
    public Culinary formDTOToCulinary(CulinaryDTO dto) {
        Item item = itemRepository.findByItemId(dto.getItemId())
                .orElseThrow(() -> new NoSuchElementException("Item não encontrado"));

        List<Ingredient> ingredients = dto.getIngredients().stream().map(ing -> {
            Item ingredientItem = itemRepository.findByItemId(ing.getItemId())
                    .orElseThrow(() -> new NoSuchElementException("Item de ingrediente não encontrado"));
            Ingredient i = new Ingredient();
            i.setItem(ingredientItem);
            i.setQuantity(ing.getQuantity());
            return i;
        }).toList();

        List<Bonus> bonuses = dto.getBonuses().stream().map(b -> {
            Bonus bonus = new Bonus();
            bonus.setLevel(b.getLevel());
            bonus.setDuration(b.getDuration());
            return bonus;
        }).toList();

        Culinary c = new Culinary();
        c.setItem(item);
        c.setIngredients(ingredients);
        c.setBonuses(bonuses);
        c.setEnergy(dto.getEnergy());
        c.setHealth(dto.getHealth());
        c.setFont(dto.getFont());
        return c;
    }
}
