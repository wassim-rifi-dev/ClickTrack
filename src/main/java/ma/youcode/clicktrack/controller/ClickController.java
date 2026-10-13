package ma.youcode.clicktrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t")
public class ClickController {

    @GetMapping("/{id}")
    public void addClick(@PathVariable("id") Long linkId) {}
}
