package com.example.ss4_1.controller;

import com.example.ss4_1.model.Product;
import com.example.ss4_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/")
    public String displayList(Model model) {
        List<Product> productList = productService.displayProducts();
        model.addAttribute("prodList", productList);
        return "home";
    }

    @GetMapping("/add-product")
    public ModelAndView addProductPage() {
        return new ModelAndView("add","product",new Product());
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        List<Product> productList = productService.displayProducts();
        redirectAttributes.addFlashAttribute("prodList", productList);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String updateProductPage(@PathVariable int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("prod", product);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute (name="prod")Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product);
        List<Product> productList = productService.displayProducts();
        redirectAttributes.addFlashAttribute("prodList", productList);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model) {
        productService.deleteProduct(id);
        List<Product> productList = productService.displayProducts();
        model.addAttribute("prodList", productList);
        return "home";
    }

    @GetMapping("/find-product")
    public String findProductByName(@RequestParam String input, Model model) {
        List<Product> productList = productService.findProductByName(input);
        model.addAttribute("prodList", productList);
        return "home";
    }
    @GetMapping("/{id}/details")
    public String viewDetails(@PathVariable int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "details";
    }
}
