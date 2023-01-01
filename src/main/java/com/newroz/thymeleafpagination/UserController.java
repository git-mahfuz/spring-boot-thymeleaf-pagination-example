package com.newroz.thymeleafpagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String getUsers(
            Model model,
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) UserStatus status
    ) {

        UserSearchFormParam userSearchFormParam = new UserSearchFormParam(name, email, status);
        Page<User> page = userService.getUsers(pageable, userSearchFormParam);

        model.addAttribute("search", userSearchFormParam);
        model.addAttribute("page", page);
        return "index";
    }

}


