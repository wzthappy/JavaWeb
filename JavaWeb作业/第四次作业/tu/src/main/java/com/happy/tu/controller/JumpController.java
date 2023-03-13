package com.happy.tu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("JavaWeb")
public class JumpController {
  @GetMapping("/student.do")
  public String studentDo() {
    return "student";
  }

  @PostMapping("/1")
  @ResponseBody
  public String[] xz1 (@RequestParam("xz") String xz) {

    String[] strs = {"HelloKitty1", "Doraemon2", "AngryBird3", "SpongeBob4"};
    int index = Integer.parseInt(xz.substring(xz.length() - 1)) - 1;
    String[] newStrs = new String[4];

    for (int i = index; i <= 3; i++) {
      newStrs[i - index] = strs[i];
    }
    int in = strs.length - index;
    for (int i = 0; i < index; i++) {
      newStrs[in] = strs[i];
      in++;
    }
    return newStrs;
  }
}
