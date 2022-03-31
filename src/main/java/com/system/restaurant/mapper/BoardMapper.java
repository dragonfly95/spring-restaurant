package com.system.restaurant.mapper;

import com.system.restaurant.controller.Board;
import com.system.restaurant.controller.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardMapper {
    List<Board> boardList(Page page);

    int countBoard(Page page);

    void insertBatch(Map<String, Object> data);

    HashMap boardView(Integer id);

    int saveBoard(Board board);

    int updateBoard(Board board);

}
