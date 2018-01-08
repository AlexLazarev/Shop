package alex.stud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selected")
public class SelectedController {
    @GetMapping("/main")
    public String main(){
        return "redirect:/main";
    }

    @GetMapping("/shop")
    public String shop(){
        return "redirect:/shop";
    }
}
