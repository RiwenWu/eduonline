package com.eduonline.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.model.Video;
import com.eduonline.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@ResponseBody
	@RequestMapping(value = "/queryVideoById.json")
	public Map<String, Object> queryVideoById(String videoId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//String 转 Long
		Long vId = Long.parseLong(videoId);
		Video video = new Video();
		map.put("bool", false);
		try {
			video = videoService.selectByPrimaryKey(vId);
			map.put("data", video);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
