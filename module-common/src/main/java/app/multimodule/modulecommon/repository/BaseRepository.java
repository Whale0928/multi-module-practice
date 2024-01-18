package app.multimodule.modulecommon.repository;

import app.multimodule.modulecommon.domain.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<BaseEntity, Long> {
}
