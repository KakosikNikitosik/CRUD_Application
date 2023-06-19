package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String printListOfUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping(value = "/users/new")
    public String newUserForCreating(Model model, String firstName, String lastName, String email) {
        model.addAttribute("newUser", new User(firstName, lastName, email));
        return "new";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("newUser") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/show")
    public String show(@RequestParam (required = false) Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/edit/{id}")
    public String getEditUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }
    @PostMapping("/{id}")
    public String updateUser( @PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}