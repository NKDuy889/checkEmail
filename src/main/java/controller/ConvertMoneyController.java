package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moneys")
public class ConvertMoneyController {
    @GetMapping("view/{moneyAmerican}")
    public ModelAndView convertMoney(@PathVariable Integer moneyAmerican) {
        ModelAndView modelAndView = new ModelAndView("view");
        Integer money = moneyAmerican * 23000;
        modelAndView.addObject("money", money);
        modelAndView.addObject("money1", moneyAmerican);
        return modelAndView;
    }
    @GetMapping("")
    public ModelAndView tc(){
        ModelAndView modelAndView = new ModelAndView("indexx");
        return modelAndView;
    }
    @GetMapping("/validate")
    public ModelAndView cc(){
        ModelAndView modelAndView = new ModelAndView("checkMail");
        return modelAndView;
    }
    @PostMapping("/validate")
    public String validate (@RequestParam("email") String email, Model model){
        if (!email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")){
            model.addAttribute("mess", "Email is invalid");
            return "checkMail";
        }
        model.addAttribute("email", email);
        return "success";
    }
}
