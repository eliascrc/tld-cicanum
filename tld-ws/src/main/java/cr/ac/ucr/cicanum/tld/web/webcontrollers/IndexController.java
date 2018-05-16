package cr.ac.ucr.cicanum.tld.web.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView printIndex() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("text", "This is a Controller test");

        return mav;
    }
}