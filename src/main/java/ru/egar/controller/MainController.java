package ru.egar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.egar.model.Zakaz;
import ru.egar.service.ZakazService;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private ZakazService zakazService;

    @Autowired
    public void setZakazService(ZakazService zakazService) {
        this.zakazService = zakazService;
    }

    @GetMapping
    public String getZakaz(Model model) {
        HashMap<Object, Object> data = new HashMap<>();
        Zakaz zakaz = zakazService.getById(1);
        data.put("messages", zakazService.allZakaz());

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", true);
        return "index";
    }
}
