package com.example.controller;

import com.example.service.DataService;
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
public class ReportController {

    @RequestMapping(value="/raport", method = RequestMethod.POST)
    public void Generuj(@ModelAttribute("SpringWeb") DataService dataService, ModelMap model){
        model.addAttribute("dane", dataService.InsertQuery());
    }


}
