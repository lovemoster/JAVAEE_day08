package com.powernode.dao;

import com.powernode.entity.Province;

import java.sql.Connection;

public interface ProvinceDao {
    Province queryProvinceById(Integer id, Connection conn);
}
