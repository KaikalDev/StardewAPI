package kaique.luan.dev.stardewapi.domain.repository;

import kaique.luan.dev.stardewapi.domain.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItensRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByItemId(Long itemId);

    boolean existsByItemId(Long itemId);

}
