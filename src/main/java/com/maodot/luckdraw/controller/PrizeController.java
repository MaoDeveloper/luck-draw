package com.maodot.luckdraw.controller;

import java.util.HashMap;
import java.util.List;

import com.maodot.luckdraw.application.admin.PrizeService;
import com.maodot.luckdraw.controller.dto.MessageEntity;
import com.maodot.luckdraw.controller.dto.PrizeParam;
import com.maodot.luckdraw.controller.dto.PrizeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/luck_draw/prize")
public class PrizeController {

	@Autowired
	private PrizeService prizeService;

	@RequestMapping("/list")
	public MessageEntity list(@RequestParam(value = "name", defaultValue = "") String name,
							  @RequestParam(value = "type", defaultValue = "") Integer type,
							  @RequestParam(value = "prizeStatus", defaultValue = "") Integer prizeStatus,
							  @RequestParam(value = "page", defaultValue = "1") int page,
							  @RequestParam(value = "size", defaultValue = "10") int size) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		List<PrizeResult> result = prizeService.list(name, type, prizeStatus, page, size);
		int count = prizeService.count(name, type, prizeStatus);
		HashMap<String, Object> fullResult = new HashMap<>();
		fullResult.put("total", count);
		fullResult.put("list", result);

		return builder.code(200).success(true).content(fullResult).create();
	}

	@RequestMapping("/save")
	public MessageEntity save(@RequestBody PrizeParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		prizeService.save(param);
		return builder.code(200).success(true).create();
	}

	@RequestMapping("/delete")
	public MessageEntity delete(@RequestBody PrizeParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		prizeService.delete(param);
		return builder.code(200).success(true).create();
	}

}
