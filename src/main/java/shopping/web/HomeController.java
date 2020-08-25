package shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import shopping.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("products", this.productService.findAllProducts());
            modelAndView.addObject("drinks", this.productService.findAllDrinks());
            modelAndView.addObject("foods", this.productService.findAllFoods());
            modelAndView.addObject("households", this.productService.findAllHouseholds());
            modelAndView.addObject("others", this.productService.findAllOthers());
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
