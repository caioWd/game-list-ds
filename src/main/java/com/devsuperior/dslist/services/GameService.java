package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(x-> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional
    public GameDTO findById(Long gameId){
        Game game = gameRepository.findById(gameId).get();
        GameDTO dto = new GameDTO(game);
        return dto;
    }

}
