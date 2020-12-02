package config;

/**
 *
 * 基于aop的多数据源
 *
 * @author jiangtao@linkedme.cc
 * @since 2019/08/27
 */
public class DataSourceTypeConfig {

    private static final ThreadLocal<MultiDataSourceTypeEnum> DATA_SOURCE_TYPE_ENUM = ThreadLocal.withInitial(() -> MultiDataSourceTypeEnum.One);

    public static MultiDataSourceTypeEnum get(){
        return DATA_SOURCE_TYPE_ENUM.get();
    }

    public static void set(MultiDataSourceTypeEnum dataSourceType){
        DATA_SOURCE_TYPE_ENUM.set(dataSourceType);
    }


}
