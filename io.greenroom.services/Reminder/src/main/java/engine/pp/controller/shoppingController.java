package engine.pp.controller;

import engine.pp.services.shoppingService;
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
public class shoppingController {

    @RequestMapping(value="/raport", method = RequestMethod.POST)
    public void Generuj(@ModelAttribute("SpringWeb") shoppingService shoppingService, ModelMap model){
        model.addAttribute("data", shoppingService.getName());
    }


}
