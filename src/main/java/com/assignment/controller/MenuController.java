package com.assignment.controller;

import com.assignment.model.Menu;
import com.assignment.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/manipulate")
    public Menu manipulateMenu(@RequestParam String inputs) {
        return menuService.manipulateMenu(inputs);
    }
}

