package th.ac.ku.kinkao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.kinkao.model.Restaurant;
import th.ac.ku.kinkao.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
//    private List<Restaurant> restaurantList = new ArrayList<>();
    @Autowired
    private RestaurantService service;

    @GetMapping
    public String getRestaurant(Model model) {
//        model.addAttribute("restaurants", restaurantList);
        model.addAttribute("restaurants", service.getAll());
        return "restaurants";
    }

    @GetMapping("/add")
    public String getAddForm() {
        return "restaurant-add"; // return restaurant-add.html
    }

    @PostMapping("/add")
    public String addRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
//        restaurantList.add(restaurant);
        service.addRestaurant(restaurant);
        return "redirect:/restaurant";
    }
}
