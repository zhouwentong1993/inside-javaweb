package com.puhui.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@ConfigurationProperties(prefix = "mybatis", locations = {"classpath*:mybatis.properties"})
public class MybatisConfigProperties {
    private String mapperLocations;
    private String typeAliasPackage;

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasPackage() {
        return typeAliasPackage;
    }

    public void setTypeAliasPackage(String typeAliasPackage) {
        this.typeAliasPackage = typeAliasPackage;
    }

}