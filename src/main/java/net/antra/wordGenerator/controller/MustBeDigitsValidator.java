package net.antra.wordGenerator.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MustBeDigitsValidator implements ConstraintValidator<MustBeDigits,String> {
   /*public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }*/



    public void initialize(MustBeDigits constraintAnnotation) {

    }

    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        Set<Character> set=new HashSet<Character>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        if (string!=null){
            for(int i=0;i<string.length();i++){
                if(!set.contains(string.charAt(i))){
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate("digits only!!!").addConstraintViolation();
                    return false;
                }

            }
        }
        return true;
    }
}
