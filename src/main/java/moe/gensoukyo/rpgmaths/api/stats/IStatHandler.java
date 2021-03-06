package moe.gensoukyo.rpgmaths.api.stats;

/**
 * 每个数据拥有者的人物属性数据
 * @implNote ❌不要继承❌
 * @author Chloe_koopa
 */
public interface IStatHandler
{
    /**
     * 获取某一项数据
     * @param type 属性类型
     * @return 该handler宿主实体的某项数据
     */
    double getBaseValue(IStatType type);

    /**
     * 获取某一项数据
     * @param type 属性类型
     * @return 该handler宿主实体的某项数据
     */
    double getFinalValue(IStatType type);

    /**
     * 设置某一项的数据
     * @param type 数据种类
     * @param value 该数据要设置成的值
     * @return 这次设置数据是否有效
     */
     boolean setBaseValue(IStatType type, double value);

    /**
     * 将某一项数据增加一定值
     * @param type 数据种类
     * @param value 该数据要设置成的值
     * @return 这次设置数据是否有效
     */
     @SuppressWarnings("unused")
     default boolean addTo(IStatType type, double value)
     {
         return setBaseValue(type, getBaseValue(type) + value);
     }
}