package myProject.first_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/") // 첫 접속 주소 (localhost:8080
    public String home(){
        return "home"; // home.html 파일을 찾아가라는 뜻
    }
}
