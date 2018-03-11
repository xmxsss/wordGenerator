package net.antra.wordGenerator.controller;


import net.antra.wordGenerator.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class testHandler {

    @RequestMapping("/hello")
    public String springDemo(Model model) {

        model.addAttribute("user", "Mingxuan Xie");
        return "/demo";

    }

    @RequestMapping("/Json")
    @ResponseBody
    public Message JsonDemo() {
        Message message = new Message();
        message.setText("json is working!");
        return message;
    }
}
