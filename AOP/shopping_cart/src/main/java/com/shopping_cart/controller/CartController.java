package com.shopping_cart.controller;

import com.shopping_cart.model.Product;
import com.shopping_cart.model.dto.CartDto;
import com.shopping_cart.model.dto.ProductDto;
import com.shopping_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                           Model model) {
        model.addAttribute("cartDto", cartDto);
        return "cart-list";
    }

    @GetMapping("/minus/{id}")
    public String minus(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                        @PathVariable Long id,
                        Model model) {
        Product product = this.productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        if (cartDto.getProducts().get(productDto) <= 1) {
            model.addAttribute("message", "Invalid action");
        } else {
            cartDto.removeProduct(productDto);
        }
        return "cart-list";
    }

    @GetMapping("/additional/{id}")
    public String additional(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                             @PathVariable Long id,
                             RedirectAttributes redirectAttributes) {
        Product product = this.productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Product is out of stock");
        } else {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}