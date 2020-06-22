package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.dao.TeacherMapper;
import com.mybatis.demo.ShowMybatis;
@WebServlet("/two")
public class ServletTwo extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String s = ShowMybatis.getSqlSession().getMapper(TeacherMapper.class).findOne(2).toString();
        resp.getWriter().write(s);
    }
}
