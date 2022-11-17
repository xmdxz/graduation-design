package com.boot.common.request.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;


@Data
@ApiModel("分页结果")
public class PageResult<T> {

    // 数据总量
    private Long total;

    // 当前页的数据
    private List<T> records;

    public PageResult() {
    }

    public PageResult(IPage<T> page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
    }

    public PageResult(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public static <E> PageResult<E> buildResult(IPage<E> page) {
        return new PageResult<>(page);
    }

    public static <E> PageResult<E> buildResult(Long total, List<E> records) {
        return new PageResult<>(total, records);
    }

}
