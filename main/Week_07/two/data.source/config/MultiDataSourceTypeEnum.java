package config;

/**
 * @author jiangtao@linkedme.cc
 * @since 2019/08/27
 */
public enum MultiDataSourceTypeEnum {

    One("dataSourceOne"), Two("dataSourceTwo"), Three("dataSourceThree"), Four("dataSourceFour");

    private String name;

    MultiDataSourceTypeEnum(String name) {
        this.name = name;
    }
}
