package kaique.luan.dev.stardewapi.service.intefaces;

import kaique.luan.dev.stardewapi.domain.models.Culinary;

import kaique.luan.dev.stardewapi.domain.models.DTO.CulinaryDTO;

import java.util.List;

public interface ICulinaryService {

    Culinary create(CulinaryDTO dto);

    Boolean deleteCulinary(Culinary culinaryToDelete);

    Culinary updateCulinary(Culinary culinaryToUpdate);

    Culinary getCulinaryByItemId(Long itemId);

    Culinary formDTOToCulinary(CulinaryDTO dto);

    List<Culinary> getAllCulinarys();

}
