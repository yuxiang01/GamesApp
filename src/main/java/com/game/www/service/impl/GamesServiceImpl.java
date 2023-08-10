package com.game.www.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.game.www.entity.Games;
import com.game.www.mapper.GamesMapper;
import com.game.www.service.GamesService;
import org.springframework.stereotype.Service;

@Service
public class GamesServiceImpl
    extends ServiceImpl<GamesMapper, Games>
    implements GamesService {
}
