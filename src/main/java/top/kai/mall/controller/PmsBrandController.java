package top.kai.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 品牌管理Controller
 * @Author Kai
 * @Date 2020/12/26 21:27
 */
@RestController
@RequestMapping("/")
public class PmsBrandController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
