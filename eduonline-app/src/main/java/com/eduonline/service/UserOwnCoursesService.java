package com.eduonline.service;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

public interface UserOwnCoursesService {

	void markUserCourse(Long userId, String courseIds);
	
	boolean findUserIsOwn(Long userId, String courseId);
}
