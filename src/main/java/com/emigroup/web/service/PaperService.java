package com.emigroup.web.service;

import com.emigroup.web.dao.PaperMapper;
import com.emigroup.web.vo.Paper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Transactional
@Service
public class PaperService {
    @Resource
    PaperMapper paperMapper;

    /**
     * 获取年份集
     *
     * @return
     */
    public Set<Integer> findYear() {
        HashSet<Integer> listYear = new HashSet<Integer>();
        List<Paper> paperList = paperMapper.findAll();
        for (int i = 0; i < paperList.size(); i++) {
            listYear.add(Integer.parseInt(paperList.get(i).getDate().substring(0, 4)));
        }
        return listYear;

    }

    /**
     * 获取所有paper
     *
     * @return
     */
    public List<Paper> findPaper() {
        List<Paper> paperList = paperMapper.findAll();
        return paperList;
    }
    public Paper findById(int id){
        return paperMapper.findById(id);
    }

    /**
     * 增加paper
     * @return
     */
    public int addPaper(Paper paper){
        return paperMapper.insert(paper.getTitle(), paper.getAuthor(), paper.getJournal(), paper.getDate(), paper.getPlace(), paper.getType());
    }

    public int update(Paper paper){
        return paperMapper.update(paper.getId(),paper.getTitle(),paper.getAuthor(),paper.getJournal(),paper.getDate(),paper.getPlace(),paper.getType());
    }

    public int deleteById(int id){
        return paperMapper.deleteById(id);
    }

}
