package kaique.luan.dev.stardewapi.domain.repository;

import kaique.luan.dev.stardewapi.domain.models.Culinary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CulinaryRepository extends JpaRepository<Culinary, Long> {
}
