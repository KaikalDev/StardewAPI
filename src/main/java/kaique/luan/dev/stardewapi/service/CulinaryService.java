package kaique.luan.dev.stardewapi.service;

import kaique.luan.dev.stardewapi.domain.models.Culinary;
import kaique.luan.dev.stardewapi.domain.repository.CulinaryRepository;
import kaique.luan.dev.stardewapi.service.intefaces.ICulinaryService;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.NoSuchElementException;

public class CulinaryService implements ICulinaryService {

    private final CulinaryRepository culinaryRepository;

    public CulinaryService(CulinaryRepository culinaryRepository) {
        this.culinaryRepository = culinaryRepository;
    }

    @Override
    public Culinary create(Culinary culinaryToAdd) {
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
    public Culinary getCulinaryByItemId(Integer itemId) {
        return culinaryRepository.findCulinaryByItem_ItemId(Long.valueOf(itemId))
                .orElseThrow(() -> new NoSuchElementException("Culinary with itemId " + itemId + " not found."));
    }

    @Override
    public List<Culinary> getAllCulinarys() {
        return culinaryRepository.findAll();
    }
}
