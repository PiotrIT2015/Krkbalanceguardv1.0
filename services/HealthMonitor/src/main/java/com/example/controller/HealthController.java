package com.example.controller;

import com.example.service.HealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Piotr
 */

@Controller
public class HealthController {

    @RequestMapping(value="/raport", method = RequestMethod.POST)
    public void Generuj(@ModelAttribute("SpringWeb") HealthService healthService, ModelMap model){
        model.addAttribute("dane", healthService.InsertQuery());
    }


}
