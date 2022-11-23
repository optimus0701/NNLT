package com.optimus.nnlt.controller

import com.optimus.nnlt.global.GlobalData
import com.optimus.nnlt.model.Product
import com.optimus.nnlt.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/cart")
    String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }//page cart

    @GetMapping("/addToCart/{id}")
    String addToCart(@PathVariable int id){
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }//click add from page viewProduct

    @GetMapping("/cart/removeItem/{index}")
    String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    } // delete 1 product

    @GetMapping("/checkout")
    String checkout(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        //model.addAttribute("cart", GlobalData.cart);
        return "checkout";
    } // checkout totalPrice

    @RequestMapping(value = "/payNow", method = [RequestMethod.GET, RequestMethod.POST])
    String payNow() {
        GlobalData.cart.removeAll()
        GlobalData.cart.clear()
        return "redirect:/"
    }
}