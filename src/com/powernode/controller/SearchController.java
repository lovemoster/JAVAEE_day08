package com.powernode.controller;

import com.alibaba.fastjson.JSON;
import com.powernode.entity.Province;
import com.powernode.service.SearchService;
import com.powernode.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "queryProvinceById", urlPatterns = "/queryProvinceById", loadOnStartup = 1)
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String province_id = req.getParameter("id");
        if (province_id != null && !"".equals(province_id)) {
            SearchService service = new SearchServiceImpl();
            Integer id = Integer.parseInt(province_id.trim());
            Province province = service.queryProvinceById(id);
            String res = JSON.toJSONString(province);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(res);
        }
    }
}
