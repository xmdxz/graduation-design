package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Notice;
import com.boot.dal.mapper.NoticeMapper;
import org.springframework.stereotype.Service;


@Service
public class NoticeRepository extends ServiceImpl<NoticeMapper, Notice> {
}
