package ru.egar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.clientsoap.client.SoapClient;
import ru.clientsoap.wsdl.GetTimeResponse;
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

    private SoapClient soapClient;

    @Autowired
    public void setSoapClient(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @GetMapping
    public String getZakaz(Model model) {
        GetTimeResponse response = soapClient.getDateTimeRemote(1);

        HashMap<Object, Object> data = new HashMap<>();
        data.put("messages", zakazService.allZakaz());
        data.put("soaptime", response.getDatetime());

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", true);
        return "index";
    }
}
