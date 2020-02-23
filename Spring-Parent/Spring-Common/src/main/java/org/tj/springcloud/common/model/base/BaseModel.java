package org.tj.springcloud.common.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
@Data
public class BaseModel {

    /**
     * @描述
     * @参数 主键id
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/11
     * @创建时间 22:04
     */
    @TableId(type = IdType.UUID)
    protected String id;
}
