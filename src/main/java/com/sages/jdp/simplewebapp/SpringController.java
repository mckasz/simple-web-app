package com.sages.jdp.simplewebapp;

import com.sages.jdp.simplewebapp.planetary.PlanetaryService;
import com.sages.jdp.simplewebapp.planetary.WebClient;
import com.sages.jdp.simplewebapp.planetary.APOD;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Locale;


@Controller
public class SpringController {

    private final PlanetaryService planetaryService = new PlanetaryService(new WebClient());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String picture(Locale locale, Model model) throws IOException {
        System.out.println("Called Index");
        APOD picture = planetaryService.getPicture();
        System.out.println("Picture " + picture.title);
        model.addAttribute("picture", picture);
        return "index";
    }
}