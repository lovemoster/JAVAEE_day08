package com.powernode.service.impl;

import com.powernode.dao.ProvinceDao;
import com.powernode.dao.impl.ProvinceDaoImpl;
import com.powernode.entity.Province;
import com.powernode.service.SearchService;
import com.powernode.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class SearchServiceImpl implements SearchService {
    @Override
    public Province queryProvinceById(Integer id) {
        Connection conn = DBUtil.getConnection();
        ProvinceDao provinceDao = new ProvinceDaoImpl();
        Province province = provinceDao.queryProvinceById(id, conn);
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return province;
    }
}
