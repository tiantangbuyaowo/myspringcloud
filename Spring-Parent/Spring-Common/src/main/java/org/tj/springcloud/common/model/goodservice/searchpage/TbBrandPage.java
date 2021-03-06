package org.tj.springcloud.common.model.goodservice.searchpage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.tj.springcloud.common.model.base.Page;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TbBrandPage extends Page {

    private String name;
}
