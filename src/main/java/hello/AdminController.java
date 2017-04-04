package hello;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.Services;
import hello.producers.KafkaProducer;
import model.Categoria;
import model.exception.BusinessException;

@Controller
public class AdminController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("message", new Message());
        return "index";
    }
    

    

}