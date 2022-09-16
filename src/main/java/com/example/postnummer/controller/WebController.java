package com.example.postnummer.controller;

import com.example.postnummer.service.FindCity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {
    private FindCity findCity;

    public WebController() {
        findCity = new FindCity();
    }

    @GetMapping("/")
    public String AreaFinder(){
        return "areafinder";
    }

    @PostMapping("/yourarea")
    public String yourArea(@RequestParam("areacode") String areaCode, RedirectAttributes redirectAttributes){
        System.out.println(areaCode);
        redirectAttributes.addAttribute("areacode", areaCode);
        return "redirect:/yourarea";
    }

    @GetMapping("/yourarea")
    public String areaFound(@RequestParam("areacode") String areaCode, Model model){
        //String city = findCity.find(areacode);
        String city = findCity.findCity(areaCode);
        System.out.println(city);
        model.addAttribute("area",city);
        return "success";
    }
}