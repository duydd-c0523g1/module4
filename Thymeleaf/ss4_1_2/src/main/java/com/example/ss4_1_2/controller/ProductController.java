package com.example.ss4_1_2.controller;

import com.example.ss4_1_2.model.Product;
import com.example.ss4_1_2.service.IProductService;
import com.example.ss4_1_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showHomePage() {
        return new ModelAndView("home", "productList", productService.displayList());
    }

    @GetMapping("/add")
    public ModelAndView showAddNewPage() {
        return new ModelAndView("add", "product", "");
    }
    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        if (productService.addProduct(product)) {
            redirectAttributes.addFlashAttribute("productList", productService.displayList());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Add failed!");
            return "add";
        }
    }
    @GetMapping("/{id}/update")
    public ModelAndView showUpdatePage(@PathVariable int id) {
        Product product = productService.findProductById(id);
        return new ModelAndView("update", "product", product);
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        if (productService.updateProduct(product)) {
            redirectAttributes.addFlashAttribute("productList", productService.displayList());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Update failed!");
            return "update";
        }
    }
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model) {
        if (productService.deleteProduct(id)) {
            model.addAttribute("productList", productService.displayList());
            return "home";
        } else {
            model.addAttribute("error", "Delete failed");
            return "home";
        }
    }
}
