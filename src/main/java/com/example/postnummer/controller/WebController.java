package com.example.postnummer.controller;

import com.example.postnummer.service.FindCity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;

@Controller
public class WebController {
    private FindCity findCity;

    public WebController() throws FileNotFoundException {
        findCity = new FindCity();
    }

    @GetMapping("/")
    public String AreaFinder(){
        return "areafinder";
    }

    @PostMapping("/yourarea")
    public String findArea(@RequestParam("area")String area, RedirectAttributes redirectAttributes){
        System.out.println(area);
        redirectAttributes.addAttribute("area",area);
        return "redirect:/yourarea";
    }

    @GetMapping("/yourarea")
    public String areaFound(@RequestParam("area")String area, Model model){
        String city = findCity.find(area);
        System.out.println(city);
        model.addAttribute("area",city);
        return "success";
    }
}