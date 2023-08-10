package com.game.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.game.www.entity.Games;
import com.game.www.service.GamesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class GamesController {

  @Resource
  GamesService gamesService;

  @GetMapping("/")
  public String index() {
    return "select";
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

  @GetMapping("/list")
  @ResponseBody
  List<Games> list() {
    return gamesService.list();
  }
}
