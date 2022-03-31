package com.system.restaurant.controller;

import com.system.restaurant.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {


    @Autowired
    private BoardMapper boardMapper;

    @RequestMapping(value = "board.do", method = RequestMethod.GET)
    public String boardList(Page page, Model model) {

        List<Board> list = boardMapper.boardList(page);
        int total = boardMapper.countBoard(page);

        page.setTotal(total);

        model.addAttribute("list", list);

        // data 없을 때 10000건 등록
        if (total == 0) {
            List<Board> data = new ArrayList<Board>();
            for (int i = 0; i < 10000; i++) {
                data.add(new Board("title"+i, "content"+i));

                int row = i % 1000;
                if (row == 0 && i != 0) {
                    Map<String, Object> batchData = new HashMap<>();
                    batchData.put("data", data);
                    boardMapper.insertBatch(batchData);
                    data.clear();
                }
            }
        }


        return "board/list";

    }


}
