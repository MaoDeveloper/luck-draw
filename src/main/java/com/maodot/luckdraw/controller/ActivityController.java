package com.maodot.luckdraw.controller;

import java.util.HashMap;
import java.util.List;

import com.maodot.luckdraw.application.admin.ActivityService;
import com.maodot.luckdraw.controller.dto.ActivityParam;
import com.maodot.luckdraw.controller.dto.ActivityResult;
import com.maodot.luckdraw.controller.dto.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/luck_draw/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping("/list")
	public MessageEntity list(@RequestParam(value = "name", defaultValue = "") String name,
							  @RequestParam(value = "activityStatus", defaultValue = "") Integer activityStatus,
							  @RequestParam(value = "page", defaultValue = "1") int page,
							  @RequestParam(value = "size", defaultValue = "10") int size) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		List<ActivityResult> result = activityService.list(name, activityStatus, page, size);
		int count = activityService.count(name, activityStatus);
		HashMap<String, Object> fullResult = new HashMap<>();
		fullResult.put("total", count);
		fullResult.put("list", result);

		return builder.code(200).success(true).content(fullResult).create();
	}

	@RequestMapping("/save")
	public MessageEntity save(@RequestBody ActivityParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		activityService.save(param);
		return builder.code(200).success(true).create();
	}

	@RequestMapping("/delete")
	public MessageEntity delete(@RequestBody ActivityParam param) {
		MessageEntity.Builder builder = new MessageEntity.Builder();
		activityService.delete(param);
		return builder.code(200).success(true).create();
	}

}
