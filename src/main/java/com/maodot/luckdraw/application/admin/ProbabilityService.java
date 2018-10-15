package com.maodot.luckdraw.application.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.maodot.luckdraw.controller.dto.ProbabilityParam;
import com.maodot.luckdraw.controller.dto.ProbabilityResult;
import com.maodot.luckdraw.infrastructure.repository.ProbabilityRepo;
import com.maodot.luckdraw.infrastructure.repository.dto.ProbabilityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProbabilityService {

/*************************** 实参 ***************************/

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

/***************************以下是模块内部接口注入***************************/
	@Autowired
	private ProbabilityRepo probabilityRepo;

/***************************以下是模块外部服务注入***************************/

	public List<ProbabilityResult> list(String prizeCode, int page, int size) {
		List<ProbabilityResult> result = new ArrayList<>();

		int skip = (page -1) * size;
		Collection<ProbabilityDto> list = this.probabilityRepo.listByCondition(prizeCode, skip, size);
		for (ProbabilityDto obj : list) {
			ProbabilityResult res = new ProbabilityResult();
			res.initFromDto(obj);
			result.add(res);
		}
		return result;
	}

	public int count(String prizeCode) {
		int result = this.probabilityRepo.countByCondition(prizeCode);
		return result;
	}

	public void save(ProbabilityParam param) {
		ProbabilityDto obj = param.toDto();

		String primaryCode = param.getProbabilityCode();
		ProbabilityDto old = null;
		if (primaryCode != null) {
			old = this.probabilityRepo.getOne(primaryCode);
			if(old != null) {
				obj.setId(old.getId());
			}
		}

		if (obj.getId() != null) {
			this.probabilityRepo.update(obj);
		} else {
			obj.setProbabilityCode(createPrimaryCode());
			this.probabilityRepo.create(obj);
		}
	}

	public void delete(ProbabilityParam param) {
		String primaryCode = param.getProbabilityCode();
		ProbabilityDto old = null;
		if (primaryCode != null) {
			old = this.probabilityRepo.getOne(primaryCode);
			if(old != null) {
				this.probabilityRepo.delete(old.getId());
			}
		}
	}
	
	private String createPrimaryCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}