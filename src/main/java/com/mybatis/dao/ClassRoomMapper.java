package com.mybatis.dao;

import com.mybatis.entity.ClassRoom;

/**
 * @description:Mybatsi接口
 * @author: Cherry
 * @time: 2020/6/3 15:25
 */
public interface ClassRoomMapper {
    ClassRoom findByUuid(int uuid);
}
