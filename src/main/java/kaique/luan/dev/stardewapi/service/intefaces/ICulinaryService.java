package kaique.luan.dev.stardewapi.service.intefaces;

import kaique.luan.dev.stardewapi.domain.models.Culinary;
<<<<<<< HEAD
import kaique.luan.dev.stardewapi.domain.models.DTO.CulinaryDTO;
=======
>>>>>>> f9f3d116153838ebeae76e966abee2246afb30fd

import java.util.List;

public interface ICulinaryService {

<<<<<<< HEAD
    Culinary create(CulinaryDTO dto);
=======
    Culinary create(Culinary culinaryToAdd);
>>>>>>> f9f3d116153838ebeae76e966abee2246afb30fd

    Boolean deleteCulinary(Culinary culinaryToDelete);

    Culinary updateCulinary(Culinary culinaryToUpdate);

<<<<<<< HEAD
    Culinary getCulinaryByItemId(Long itemId);

    List<Culinary> getAllCulinarys();

    Culinary formDTOToCulinary(CulinaryDTO dto);

=======
    Culinary getCulinaryByItemId(Integer itemId);

    List<Culinary> getAllCulinarys();

>>>>>>> f9f3d116153838ebeae76e966abee2246afb30fd
}
