package com.game.www.controller;

import com.game.www.entity.Games;
import com.game.www.service.GamesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class GamesController {
  @Resource
  GamesService gamesService;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/update/{id}")
  public String toUpdatePage(@PathVariable Long id, HttpServletRequest request) {
    Games gameId = gamesService.query().eq("gameId", id).one();
    System.out.println("Games:" + gameId);
    request.setAttribute("game", gameId);
    return "update";
  }

  @GetMapping("/result.html")
  public String toResultPage() {
    return "result";
  }

  @PostMapping("/update")
  public String update(Games games, HttpServletRequest request) {
    String message = gamesService.updateById(games) ? "修改成功!" : "修改失败!";
    request.getSession().setAttribute("msg", message);
    return "redirect:result.html";
  }
}
