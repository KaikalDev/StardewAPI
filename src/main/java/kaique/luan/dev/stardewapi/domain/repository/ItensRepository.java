package kaique.luan.dev.stardewapi.domain.repository;

import kaique.luan.dev.stardewapi.domain.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Item, Long> {
}
