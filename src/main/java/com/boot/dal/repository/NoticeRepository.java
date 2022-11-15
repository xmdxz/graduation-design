package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Notice;
import com.boot.dal.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName NoticeRepository
 * @Description TODO
 * @Date 2022/11/14 16:37
 */

@Service
public class NoticeRepository extends ServiceImpl<NoticeMapper, Notice> {
}
