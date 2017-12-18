package alex.stud.controller;

import alex.stud.entity.Customer;
import alex.stud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public CustomerService customerService;

    @GetMapping("/customers")
    public String getAllUsers(Model model){
        model.addAttribute("customers",customerService.getAll());
        return "customers";
    }

    @GetMapping("customer/{id}")
    public String getById(@PathVariable("id")int id, Model model){
        model.addAttribute("customer",customerService.getById(id));
        return "showCustomer";
    }

    ///////////
    @GetMapping("/")
    public String start(){
        return "main";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin-panel";
    }

    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }


    //////////////

    @GetMapping("/addCustomer")
    public String createCustomer(){
        return "createCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("")Customer customer){ //@ModelAttribute("customer")
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerService.deleteById(id);
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("customer",customerService.getById(id));
        return "editCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer")Customer customer){
        customerService.update(customer);
        return "redirect:/customer/" + customer.getId();
    }
}
