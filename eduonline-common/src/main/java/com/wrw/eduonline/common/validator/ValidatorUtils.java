package com.wrw.eduonline.common.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.wrw.eduonline.common.utils.RRException;

/**
 * 
 *    
 * 项目名称：eduonline-common   
 * 类名称：ValidatorUtils   
 * 类描述：hibernate-vaildator校验工具类
 * 创建人：wrw   
 * 创建时间：2017年9月27日 上午11:58:15   
 * @version
 */
public class ValidatorUtils {
	
	private static Validator validator;
	
	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	/**
	 * 校验对象
	 * @param object
	 * @param groups
	 * @throws RRException
	 */
	public static void validateEntity(Object object, Class<?>... groups) throws RRException{
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
			throw new RRException(constraint.getMessage());
		}
	}
}
