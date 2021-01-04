package com.powernode.dao.impl;

import com.powernode.dao.ProvinceDao;
import com.powernode.entity.Province;
import com.powernode.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProvinceDaoImpl implements ProvinceDao {

    @Override
    public Province queryProvinceById(Integer id, Connection conn) {
        PreparedStatement statement = null;
        ResultSet res = null;
        String sql = "SELECT * FROM `province` WHERE id = ?";
        Province province = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            res = statement.executeQuery();
            if (res.next()) {
                province = new Province();
                province.setId(res.getInt("id"));
                province.setName(res.getString("name"));
                province.setJiancheng(res.getString("jiancheng"));
                province.setShenghui(res.getString("shenghui"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, statement, null);
        }
        return province;
    }
}
