package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "action") String action,
                            Model model) {
        double result = 0;
    switch (action){
        case("multiplication"):
            result = a * b;
            break;
        case("addition"):
            result = a + b;
            break;
        case ("substraction"):
            result = a - b;
            break;
        case("division"):
            result = a / (double)b;
            break;
        default:
            result = 0;
            break;
    }

        model.addAttribute("answer",result);
        return "first/calculator";
    }

    @GetMapping
    public String sayHello(@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "surname",required = false) String surname,
                           Model model){
        model.addAttribute("message","Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
