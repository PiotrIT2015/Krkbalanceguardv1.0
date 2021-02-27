package engine.pp.controller;

import engine.pp.services.healthService;
import org.springframework.stereotype.Component;
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
public class healthController {

    @RequestMapping(value="/raport", method = RequestMethod.POST)
    public void Generuj(@ModelAttribute("SpringWeb") healthService healthService, ModelMap model){
        model.addAttribute("dane",healthService.getName());
    }
}
