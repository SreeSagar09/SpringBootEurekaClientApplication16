package com.app.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
	
	@GetMapping(path = "/orderDetails")
	public ResponseEntity<Map<String, Object>> getOrderDetails(HttpServletRequest httpServletRequest){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			System.out.println("getOrderDetails execution: "+LocalDateTime.now());
			
			Map<String, Object> responseMap = new LinkedHashMap<>();
			responseMap.put("requestURL", httpServletRequest.getRequestURL().toString());
			responseMap.put("method", httpServletRequest.getMethod());
			responseMap.put("serverPort", httpServletRequest.getServerPort());
			responseMap.put("remotePort", httpServletRequest.getRemotePort());
		
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
