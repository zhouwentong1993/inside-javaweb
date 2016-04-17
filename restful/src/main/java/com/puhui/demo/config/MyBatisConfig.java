package com.puhui.demo.config;

/**
 * Created by wentong on 2016/4/12.
 */
//@Configuration
//@EnableTransactionManagement
public class MyBatisConfig/* implements TransactionManagementConfigurer */{
//    @Autowired
//    DataSource dataSource;
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean() {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setTypeAliasesPackage("com.puhui.demo.vo");
//
////        //分页插件
////        PageHelper pageHelper = new PageHelper();
////        Properties properties = new Properties();
////        properties.setProperty("reasonable", "true");
////        properties.setProperty("supportMethodsArguments", "true");
////        properties.setProperty("returnPageInfo", "check");
////        properties.setProperty("params", "count=countSql");
////        pageHelper.setProperties(properties);
////
////        //添加插件
////        bean.setPlugins(new Interceptor[]{pageHelper});
//
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            bean.setMapperLocations(resolver.getResources("classpath:com.puhui.demo.mapper/*.xml"));
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
