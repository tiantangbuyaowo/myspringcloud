package org.tj.springcloud.common.model.goodservice;import lombok.Data;import org.tj.springcloud.common.model.base.BaseModel;import java.util.List;/** * <br> * <b>功能：</b><br> * <b>作者：</b>唐靖<br> * <b>日期：</b>Mon Mar 11 22:06:10 CST 2019<br> * <b>版权所有：唐靖 */@Datapublic class TbCategoryTreeTableModel extends BaseModel {    /**     * 类目名称     */    private String name;    /**     * 父类目id,顶级类目填0     */    private Integer parentId;    /**     * 下一级的类目     */    private List<TbCategoryTreeTableModel> children;}