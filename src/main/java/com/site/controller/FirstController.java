package com.site.controller;

import com.site.DAO.UserDAO;
import com.site.models.UserClass;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/site")
public class FirstController {

    public UserDAO userDAO;

    @Autowired
    public FirstController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getAllUsers(Model model){
        List<UserClass> users = userDAO.getAll();
        model.addAttribute("users", users);
        return "pages/getAll";
    }

    @GetMapping("/create")
    public String newUser(@Valid @ModelAttribute("user") UserClass user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "redirect:/site/create";
        }
        return "pages/createUser";
    }

    @PostMapping()
    public String createUser(@RequestParam("name") String name,@RequestParam("age") int age,
                             @RequestParam("email") String email,@Valid @ModelAttribute("user") UserClass user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "redirect:/site/create";
        }
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        userDAO.save(user);
        return "redirect:/site";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        UserClass user = userDAO.show(id);
        model.addAttribute("user", user);
        return "pages/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("user") UserClass user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/failed";
        }
        userDAO.update(id, user);
        return "redirect:/site";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
            userDAO.delete(id);
        return "redirect:/site";
    }
}
