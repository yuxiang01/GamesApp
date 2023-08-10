package com.game.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.game.www.entity.Games;
import com.game.www.service.GamesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class GamesController {

  @Resource
  GamesService gamesService;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/add.html")
  public String add(){
    return "add";
  }

  @PostMapping("/add")
  public String add(Games games){
    boolean isAdd = gamesService.save(games);
    if (isAdd)
      return "redirect:/";
    else
      return "redirect:/add";
  }

  @GetMapping("/checkName")
  @ResponseBody
  public String checkName(String gameName){
    QueryWrapper<Games> queryWrapper = new QueryWrapper();
    queryWrapper.eq("gameName",gameName);
    Games one = gamesService.getOne(queryWrapper);
    String jg = one != null ? "此游戏已注册" : "";
    return jg;
  }
}
