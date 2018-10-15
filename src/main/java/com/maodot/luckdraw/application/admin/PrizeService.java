package com.maodot.luckdraw.application.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.maodot.luckdraw.controller.dto.PrizeParam;
import com.maodot.luckdraw.controller.dto.PrizeResult;
import com.maodot.luckdraw.infrastructure.repository.PrizeRepo;
import com.maodot.luckdraw.infrastructure.repository.dto.PrizeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PrizeService {

/*************************** 实参 ***************************/

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

/***************************以下是模块内部接口注入***************************/
	@Autowired
	private PrizeRepo prizeRepo;

/***************************以下是模块外部服务注入***************************/

	public List<PrizeResult> list(String name, Integer type, Integer prizeStatus, int page, int size) {
		List<PrizeResult> result = new ArrayList<>();

		int skip = (page -1) * size;
		Collection<PrizeDto> list = this.prizeRepo.listByCondition(name, type, prizeStatus, skip, size);
		for (PrizeDto obj : list) {
			PrizeResult res = new PrizeResult();
			res.initFromDto(obj);
			result.add(res);
		}
		return result;
	}

	public int count(String name, Integer type, Integer prizeStatus) {
		int result = this.prizeRepo.countByCondition(name, type, prizeStatus);
		return result;
	}

	public void save(PrizeParam param) {
		PrizeDto obj = param.toDto();

		String primaryCode = param.getPrizeCode();
		PrizeDto old = null;
		if (primaryCode != null) {
			old = this.prizeRepo.getOne(primaryCode);
			if(old != null) {
				obj.setId(old.getId());
			}
		}

		if (obj.getId() != null) {
			this.prizeRepo.update(obj);
		} else {
			obj.setPrizeCode(createPrimaryCode());
			this.prizeRepo.create(obj);
		}
	}

	public void delete(PrizeParam param) {
		String primaryCode = param.getPrizeCode();
		PrizeDto old = null;
		if (primaryCode != null) {
			old = this.prizeRepo.getOne(primaryCode);
			if(old != null) {
				this.prizeRepo.delete(old.getId());
			}
		}
	}
	
	private String createPrimaryCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}