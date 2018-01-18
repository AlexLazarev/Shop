package alex.stud.controller;

import alex.stud.entity.Producer;
import alex.stud.entity.Product;
import alex.stud.entity.Supply;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.SupplyService;
import alex.stud.service.interfaces.ProductService;
import alex.stud.service.interfaces.UserService;
import alex.stud.util.Util;
import alex.stud.validator.ProducerValidator;
import alex.stud.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private Util util;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ProducerValidator producerValidator;

    @Autowired
    private ProductValidator productValidator;

    @GetMapping("")
    public String admin() {
        return "redirect:/admin/checkProducers";
    }

    @GetMapping("/main")
    public String main(){
        return "redirect:/main";
    }

    //--Product

    @GetMapping("/checkProducts")
    public String checkProducts(Model model){
        model.addAttribute("products", productService.getAll());
        return "admin/checkProducts";
    }


    @GetMapping("/checkProducts/addProduct")
    public  String createProduct(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("supplies", supplyService.getAllSupply());
        return "admin/createProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product,BindingResult bindingResult, Model model){
        model.addAttribute("supplies",supplyService.getAllSupply()); //TODO:норма это или нет, но костыли еще никто не отменял
        productValidator.validate(product,bindingResult);
        if(bindingResult.hasErrors()){

            return "admin/createProduct";
        }
        productService.save(product);
        return "redirect:/admin/checkProducts";
    }

    //

    @GetMapping("/checkProducts/update-{id}")
    public String updateProducts(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("supplies", supplyService.getAllSupply());
        return "admin/updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProducerComplete(@ModelAttribute("product")Product product, BindingResult bindingResult) {
        productValidator.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/updateProduct";
        }
        productService.save(product);
        return "redirect:/admin/checkProducts";
    }

    @GetMapping("/checkProducts/delete-{id}")
    public String removeProduct(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/admin/checkProducts";
    }






    //--Producer

    @GetMapping("/checkProducers")
    public String checkProducers(Model model){
        model.addAttribute("producers", supplyService.getAllProducer());
        return "admin/checkProducers";
    }

    @GetMapping("/checkProducers/addProducer")
    public String createProducer(Model model){
        model.addAttribute("producer", new Producer());
        return "admin/createProducer";
    }

    @PostMapping("/addProducer")
    public String addProducer(@ModelAttribute("producer")Producer producer, BindingResult bindingResult) {
        System.out.println("Controller" + producer.toString());
        producerValidator.validate(producer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/createProducer";
        }
        supplyService.addProducer(producer);
        return "redirect:/admin/checkProducers";
    }

    @GetMapping("/checkProducers/update-{id}")
    public String updateProducer(@PathVariable("id") int id, Model model){
        model.addAttribute("producer", supplyService.getProducer(id));
        return "admin/updateProducer";
    }

    @PostMapping("/updateProducer")
    public String updateProducerComplete(@ModelAttribute("producer")Producer producer, BindingResult bindingResult) {
        System.out.println("Controller" + producer.toString());
        producerValidator.validate(producer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/updateProducer";
        }
        supplyService.addProducer(producer);
        return "redirect:/admin/checkProducers";
    }

    @GetMapping("/checkProducers/delete-{id}")
    public String removeProducer(@PathVariable("id") int id){
        supplyService.deleteProducer(id);
        return "redirect:/admin/checkProducers";
    }



    //--Supply

    @GetMapping("/checkSupply")
    public String checkSupply(Model model){
        model.addAttribute("supply", supplyService.getAllSupply());
        return "admin/checkSupply";
    }

    @GetMapping("/checkSupply/addSupply")
    public String createSupply(Model model) {
        model.addAttribute("producers",supplyService.getAllProducer());
        return "admin/createSupply";
    }

    @PostMapping("/addSupply")
    public String addSupply(@ModelAttribute("")Supply supply,@RequestParam("myDate")String date){
        supply.setDate(util.formatDate(date));
        supplyService.save(supply);
        return "redirect:/admin/checkSupply";
    }


    @GetMapping("/checkSupply/update-{id}")
    public String updateSupply(@PathVariable("id") int id, Model model){
        model.addAttribute("supply", supplyService.getSupply(id));
        model.addAttribute("producers", supplyService.getAllProducer());

        return "admin/updateSupply";
    }

    @PostMapping("/updateSupply")
    public String updateSupplyComplete(@ModelAttribute("supply")Supply supply) {
        System.out.println("Controller " + supply.toString());
        supplyService.save(supply);
        return "redirect:/admin/checkSupply";
    }

    @GetMapping("/checkSupply/delete-{id}")
    public String removeSupply(@PathVariable("id") int id){
        supplyService.delete(id);
        return "redirect:/admin/checkSupply";
    }





    //--Orders
    @GetMapping("/checkOrders")
    public String adminCheckOrders(Model model) {
        model.addAttribute("user", userService.getAll());
        model.addAttribute("order",orderService.getAll());
        model.addAttribute("product",productService.getAll());
        model.addAttribute("productInOrder", orderService.getAllProductInOrder());
        return "admin/checkOrders";
    }

    @PostMapping("/setOrderStatus/{id}")
    public String addToShoppingCart(@PathVariable("id")int id,@RequestParam("status") String status){
        System.out.println(id + " Complete " + status);
        orderService.setStatus(id,status);
        return "redirect:/admin/checkOrders";
    }

    @GetMapping("/checkOrders/delete{id}")
    public String removeOrder(@PathVariable("id") int id){
        orderService.delete(id);
        return "redirect:/admin/checkOrders";
    }

}
