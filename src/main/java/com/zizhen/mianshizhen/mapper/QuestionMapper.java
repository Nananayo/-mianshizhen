package com.zizhen.mianshizhen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zizhen.mianshizhen.model.entity.Question;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
* @author lenovo
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2025-02-02 17:38:25
* @Entity generator.domain.Question
*/
public interface QuestionMapper extends BaseMapper<Question> {

    @Select("select * from question where updateTime >= #{minUpdateTime}")
    List<Question> listQuestionWithDelete(Date minUpdateTime);

}




