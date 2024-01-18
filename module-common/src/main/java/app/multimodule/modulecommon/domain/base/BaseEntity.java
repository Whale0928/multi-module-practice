package app.multimodule.modulecommon.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false) // createdDate는 생성시간이므로 수정이 불가능하도록 설정
	private String createdBy;
	@Column(updatable = false) // createdDate는 생성시간이므로 수정이 불가능하도록 설정
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;
}
