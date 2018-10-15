package com.maodot.luckdraw.controller;

import java.util.HashMap;
import java.util.List;

import com.maodot.luckdraw.application.admin.RecordService;
import com.maodot.luckdraw.controller.dto.MessageEntity;
import com.maodot.luckdraw.controller.dto.RecordParam;
import com.maodot.luckdraw.controller.dto.RecordResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/luck_draw/record")
public class RecordController {

	@Autowired
	private RecordService recordService;

	@RequestMapping("/list")
	public MessageEntity list(@RequestParam(value = "memberCode", defaultValue = "") String memberCode,
							  @RequestParam(value = "prizeCode", defaultValue = "") String prizeCode,
							  @RequestParam(value = "page", defaultValue = "1") int page,
							  @RequestParam(value = "size", defaultValue = "10") int size) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		List<RecordResult> result = recordService.list(memberCode, prizeCode, page, size);
		int count = recordService.count(memberCode, prizeCode);
		HashMap<String, Object> fullResult = new HashMap<>();
		fullResult.put("total", count);
		fullResult.put("list", result);

		return builder.code(200).success(true).content(fullResult).create();
	}

	@RequestMapping("/save")
	public MessageEntity save(@RequestBody RecordParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		recordService.save(param);
		return builder.code(200).success(true).create();
	}

	@RequestMapping("/delete")
	public MessageEntity delete(@RequestBody RecordParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		recordService.delete(param);
		return builder.code(200).success(true).create();
	}

}
