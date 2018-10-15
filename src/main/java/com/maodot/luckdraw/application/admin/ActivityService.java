package com.maodot.luckdraw.application.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.maodot.luckdraw.controller.dto.ActivityParam;
import com.maodot.luckdraw.controller.dto.ActivityResult;
import com.maodot.luckdraw.infrastructure.repository.ActivityRepo;
import com.maodot.luckdraw.infrastructure.repository.dto.ActivityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivityService {

/*************************** 实参 ***************************/

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

/***************************以下是模块内部接口注入***************************/
	@Autowired
	private ActivityRepo activityRepo;

/***************************以下是模块外部服务注入***************************/

	public List<ActivityResult> list(String name, Integer activityStatus, int page, int size) {
		List<ActivityResult> result = new ArrayList<>();

		int skip = (page -1) * size;
		Collection<ActivityDto> list = this.activityRepo.listByCondition(name, activityStatus, skip, size);
		for (ActivityDto obj : list) {
			ActivityResult res = new ActivityResult();
			res.initFromDto(obj);
			result.add(res);
		}
		return result;
	}

	public int count(String name, Integer activityStatus) {
		int result = this.activityRepo.countByCondition(name, activityStatus);
		return result;
	}

	public void save(ActivityParam param) {
		ActivityDto obj = param.toDto();

		String primaryCode = param.getActivityCode();
		ActivityDto old = null;
		if (primaryCode != null) {
			old = this.activityRepo.getOne(primaryCode);
			if(old != null) {
				obj.setId(old.getId());
			}
		}

		if (obj.getId() != null) {
			this.activityRepo.update(obj);
		} else {
			obj.setActivityCode(createPrimaryCode());
			this.activityRepo.create(obj);
		}
	}

	public void delete(ActivityParam param) {
		String primaryCode = param.getActivityCode();
		ActivityDto old = null;
		if (primaryCode != null) {
			old = this.activityRepo.getOne(primaryCode);
			if(old != null) {
				this.activityRepo.delete(old.getId());
			}
		}
	}
	
	private String createPrimaryCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}