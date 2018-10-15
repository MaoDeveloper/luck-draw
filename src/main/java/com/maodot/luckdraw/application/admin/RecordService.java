package com.maodot.luckdraw.application.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.maodot.luckdraw.controller.dto.RecordParam;
import com.maodot.luckdraw.controller.dto.RecordResult;
import com.maodot.luckdraw.infrastructure.repository.RecordRepo;
import com.maodot.luckdraw.infrastructure.repository.dto.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RecordService {

/*************************** 实参 ***************************/

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

/***************************以下是模块内部接口注入***************************/
	@Autowired
	private RecordRepo recordRepo;

/***************************以下是模块外部服务注入***************************/

	public List<RecordResult> list(String memberCode, String prizeCode, int page, int size) {
		List<RecordResult> result = new ArrayList<>();

		int skip = (page -1) * size;
		Collection<RecordDto> list = this.recordRepo.listByCondition(memberCode, prizeCode, skip, size);
		for (RecordDto obj : list) {
			RecordResult res = new RecordResult();
			res.initFromDto(obj);
			result.add(res);
		}
		return result;
	}

	public int count(String memberCode, String prizeCode) {
		int result = this.recordRepo.countByCondition(memberCode, prizeCode);
		return result;
	}

	public void save(RecordParam param) {
		RecordDto obj = param.toDto();

		String primaryCode = param.getRecordCode();
		RecordDto old = null;
		if (primaryCode != null) {
			old = this.recordRepo.getOne(primaryCode);
			if(old != null) {
				obj.setId(old.getId());
			}
		}

		if (obj.getId() != null) {
			this.recordRepo.update(obj);
		} else {
			obj.setRecordCode(createPrimaryCode());
			this.recordRepo.create(obj);
		}
	}

	public void delete(RecordParam param) {
		String primaryCode = param.getRecordCode();
		RecordDto old = null;
		if (primaryCode != null) {
			old = this.recordRepo.getOne(primaryCode);
			if(old != null) {
				this.recordRepo.delete(old.getId());
			}
		}
	}
	
	private String createPrimaryCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}