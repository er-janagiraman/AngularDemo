package com.fa.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fa.dto.CommonDto;
import com.fa.dto.NgDto;
import com.fa.service.NgService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class NgController {

	@Resource
	NgService ngService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody NgDto ngDto) {
		System.err.println(ngDto);
		CommonDto commonDto = ngService.save(ngDto);
		return new ResponseEntity<CommonDto>(commonDto,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/fetch",method=RequestMethod.GET)
	public ResponseEntity<?> fetch(){
		CommonDto res = ngService.fetch();
		System.err.println(res);
		return new ResponseEntity<CommonDto>(res,HttpStatus.OK);
	}
	

}
