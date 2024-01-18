package app.multimodule.moduleapi.controller;

import app.multimodule.modulecommon.domain.base.BaseEntity;
import app.multimodule.modulecommon.enums.CodeEnum;
import app.multimodule.modulecommon.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

	private final BaseRepository baseRepository;

	@GetMapping
	public String helloMultimodule() {
		return "Hello from multimodule";
	}

	@GetMapping("/enums")
	public String getEnums() {
		return Arrays.toString(CodeEnum.values());
	}

	@GetMapping("/save")
	public Object save() {
		BaseEntity base = BaseEntity.builder()
			.createdBy("save")
			.createdDate(LocalDateTime.now())
			.build();

		return baseRepository.save(base);
	}
}
