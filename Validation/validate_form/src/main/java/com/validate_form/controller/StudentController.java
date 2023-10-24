package com.validate_form.controller;

import com.validate_form.model.Student;
import com.validate_form.model.StudentDTO;
import com.validate_form.service.ICourseService;
import com.validate_form.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;
    @GetMapping("")
    public ModelAndView showRegisterPage(Model model) {
        model.addAttribute("courseList", courseService.findAllCourse());
        return new ModelAndView("register", "studentDTO", new StudentDTO());
    }
    @PostMapping("/reg")
    public String register(@Validated @ModelAttribute StudentDTO studentDTO,
                           BindingResult bindingResult, Model model,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("courseList", courseService.findAllCourse());
            return "register";
        } else {
            Student student = new Student();
            BeanUtils.copyProperties(studentDTO, student);
            studentService.saveStudent(student);
            model.addAttribute("courseList", courseService.findAllCourse());
            redirectAttributes.addFlashAttribute("msg", "Success!");
            return "redirect:/";
        }
    }
}
