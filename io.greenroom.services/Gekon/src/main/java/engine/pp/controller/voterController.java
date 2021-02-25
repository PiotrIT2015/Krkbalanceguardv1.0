package engine.pp.controller;

import engine.pp.services.voterService;
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
public class voterController {

    @RequestMapping(value="/raport", method = RequestMethod.POST)
    public void Generuj(@ModelAttribute("SpringWeb") voterService voterService, ModelMap model){
        model.addAttribute("data", voterService.getItem());
    }


}
