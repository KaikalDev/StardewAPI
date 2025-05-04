package kaique.luan.dev.stardewapi.domain.repository;

import kaique.luan.dev.stardewapi.domain.models.Culinary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CulinaryRepository extends JpaRepository<Culinary, Long> {
    Optional<Culinary> findCulinaryByItem_ItemId(String itemId);

    boolean existsByItem_ItemId(String itemId);
}
