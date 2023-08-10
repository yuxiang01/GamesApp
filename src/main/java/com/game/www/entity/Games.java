package com.game.www.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("games")
@Data
public class Games implements Serializable {
  private Long gameId;
  /**
   * 游戏名称
   */
  private String gameName;
  /**
   * 游戏类型
   */
  private String gameType;
  /**
   * 发行公司
   */
  private String gameCompany;
  /**
   * 发行年份
   */
  private Integer gameYear;
}
