package net.antra.wordGenerator.controller;

import net.antra.wordGenerator.po.Message;
import net.antra.wordGenerator.service.wordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InputHandler {
    @Autowired
    wordGeneratorService service;

    @RequestMapping(value="/handleInput", method= RequestMethod.GET)
    @ResponseBody
    public Message handleInput(@Valid Message message,BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        if(bindingResult.hasErrors()) {
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            for(ObjectError error:allErrors) {
                sb.append(error.getDefaultMessage());
            }
            message.setError(sb.toString());
            return message;
        };
        //Message message = new Message();
        service.letterCombinations(message.getText());
        message.setList(service.letterPage(message.getPage()));
        message.setTotalPage(service.totalPage(message.getText()));
        return message;
    }

   /* @RequestMapping("/handleInput/{page}")
    @ResponseBody
    public Message handleInput(@PathVariable int page, String Num) {
        Message message = new Message();
        message.setText(Num);
        message.setList(service.letterCombinations(Num,page));
    }*/
}
