package com.example.demo.chen.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author chendesheng
 * @create 2019/8/30 14:22
 */
public class ParamConstraintValidated implements ConstraintValidator<Check, Object> {
    /**
     * 合法的参数值，从注解中获取
     * */
    private List<String> paramValues;

    @Override
    public void initialize(Check constraintAnnotation) {
        //初始化时获取注解上的值
        paramValues = Arrays.asList(constraintAnnotation.paramValues());
    }
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (paramValues.contains(o)) {
            return true;
        }

        //不在指定的参数列表中
        return false;
    }
}
