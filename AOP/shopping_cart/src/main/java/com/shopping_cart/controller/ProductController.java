package com.shopping_cart.controller;

import com.shopping_cart.model.Product;
import com.shopping_cart.model.dto.CartDto;
import com.shopping_cart.model.dto.ProductDto;
import com.shopping_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }
    @GetMapping
    public String showHomePage(Model model) {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            model.addAttribute("message", "List empty");
        } else {
            model.addAttribute("products", products);
        }
        return "home";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }
//    @GetMapping("/addProduct")
//    public String showFormAddProduct(Model model) {
//        model.addAttribute("product", new Product());
//        return "/product-add";
//    }
//    @PostMapping("/addProduct")
//    public String add(@ModelAttribute Product product,
//                      RedirectAttributes redirectAttributes) {
//        this.productService.addProduct(product);
//        redirectAttributes.addFlashAttribute("message", "Add new product success!!");
//        return "redirect:/";
//    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable long id,
                               HttpServletResponse response) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail", "product", productService.findById(id));
    }
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        try {
            Product product = productService.findById(id);
            if (product != null) {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                cartDto.addProduct(productDto);
                int itemQuantity = cartDto.countProductQuantity();
                model.addAttribute("itemQuantity", itemQuantity);
                redirectAttributes.addFlashAttribute("message", "Added "
                        + productDto.getName() + " to cart");
            } else {
                redirectAttributes.addFlashAttribute("message", "Product out of stock");
            }
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
            redirectAttributes.addFlashAttribute("message", "Sum ting wong!");
        } finally {
            return "redirect:/";
        }
    }
}
