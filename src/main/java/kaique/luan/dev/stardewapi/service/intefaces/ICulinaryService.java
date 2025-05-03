package kaique.luan.dev.stardewapi.service.intefaces;

import kaique.luan.dev.stardewapi.domain.models.Culinary;

import java.util.List;

public interface ICulinaryService {

    Culinary create(Culinary culinaryToAdd);

    Boolean deleteCulinary(Culinary culinaryToDelete);

    Culinary updateCulinary(Culinary culinaryToUpdate);

    Culinary getCulinaryByItemId(Integer itemId);

    List<Culinary> getAllCulinarys();

}
