package com.maodot.luckdraw.controller;

import java.util.HashMap;
import java.util.List;

import com.maodot.luckdraw.application.admin.ProbabilityService;
import com.maodot.luckdraw.controller.dto.MessageEntity;
import com.maodot.luckdraw.controller.dto.ProbabilityParam;
import com.maodot.luckdraw.controller.dto.ProbabilityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/luck_draw/probability")
public class ProbabilityController {

	@Autowired
	private ProbabilityService probabilityService;

	@RequestMapping("/list")
	public MessageEntity list(@RequestParam(value = "prizeCode", defaultValue = "") String prizeCode,
							  @RequestParam(value = "page", defaultValue = "1") int page,
							  @RequestParam(value = "size", defaultValue = "10") int size) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		List<ProbabilityResult> result = probabilityService.list(prizeCode, page, size);
		int count = probabilityService.count(prizeCode);
		HashMap<String, Object> fullResult = new HashMap<>();
		fullResult.put("total", count);
		fullResult.put("list", result);

		return builder.code(200).success(true).content(fullResult).create();
	}

	@RequestMapping("/save")
	public MessageEntity save(@RequestBody ProbabilityParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		probabilityService.save(param);
		return builder.code(200).success(true).create();
	}

	@RequestMapping("/delete")
	public MessageEntity delete(@RequestBody ProbabilityParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		probabilityService.delete(param);
		return builder.code(200).success(true).create();
	}

}
