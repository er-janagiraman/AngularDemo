package com.fa.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fa.Entity.NgEntity;
import com.fa.Repository.NgRepository;
import com.fa.dto.CommonDto;
import com.fa.dto.NgDto;
import com.fa.service.NgService;

@Service
public class NgServiceImpl implements NgService {

	@Resource
	NgRepository ngReporistory;

	@Override
	public CommonDto save(NgDto ngDto) {
		CommonDto response = new CommonDto();
		try {
			if (ngDto != null) {
				NgEntity ng = new NgEntity();
				ng.setDob(ngDto.getDob());
				ng.setEmail(ngDto.getEmail());
				ng.setGender(ngDto.getGender());
				ng.setMobile(ngDto.getMobile());
				ng.setName(ngDto.getName());
//				ng.setSkills(ngDto.getSkills);
				ng.setTeam(ngDto.getTeam());

				ngReporistory.save(ng);
				response.setStatus("Success");

			}
		} catch (Exception e) {
			response.setStatus("Failed");
		}
		return response;
	}

	@Override
	public CommonDto fetch() {
		List<NgEntity> list = ngReporistory.findAll();
		CommonDto cDto = new CommonDto();
		try {
			cDto.setResponseDto(list);
		} catch (Exception e) {
			cDto.setResponseDto(null);
		}
		return cDto;
	}

}
