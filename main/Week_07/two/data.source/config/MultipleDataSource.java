package config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author jiangtao@linkedme.cc
 * @since 2019/08/27
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceTypeConfig.get();
    }
}
