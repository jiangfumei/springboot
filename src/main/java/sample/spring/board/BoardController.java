package sample.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class BoardController {

    @Autowired
    public BoardController() {}

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String DashBoard(Model model) {
        return "dashboard";
    }
}
