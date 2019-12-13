package com.jesse.generatorCase;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class EntityGenerator {
  public static void main(String[] args) {
    // 自定义需要填充的字段
    List<TableFill> tableFillList = new ArrayList<>();
    tableFillList.add(new TableFill("create_date", FieldFill.INSERT));
    tableFillList.add(new TableFill("update_date", FieldFill.INSERT_UPDATE));

    // 代码生成器
    AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
      // 全局配置
      new GlobalConfig()
        //输出目录
//        .setOutputDir("/Users/luxuguang/IdeaProjects/yto/")
        .setOutputDir("D:\\project\\")
        // 是否覆盖文件
        .setFileOverride(true)
        // 开启 activeRecord 模式
        .setActiveRecord(false)
        // XML 二级缓存
        .setEnableCache(false)
        // XML ResultMap
        .setBaseResultMap(true)
        // XML columList
        .setBaseColumnList(true)
        .setAuthor("")
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        .setMapperName("%sMapper")
        .setXmlName("%sMapper")
        .setServiceName("%sService")
        .setServiceImplName("%sServiceImpl")
        .setEntityName("%sEntity")
      // .setControllerName("%sAction")
    ).setStrategy(
      // 策略配置
      new StrategyConfig()
        // .setCapitalMode(true)// 全局大写命名
        // .setDbColumnUnderline(true)//全局下划线命名
        // 表名生成策略
        .setNaming(NamingStrategy.underline_to_camel)
// 此处可以修改为您的表前缀
        .setTablePrefix("op")
        // 需要生成的表
        .setInclude("op_mail_log")
        // .setExclude(new String[]{"test"}) // 排除生成的表
        // 自定义实体父类
        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
        // 自定义实体，公共字段
//        .setSuperEntityColumns(new String[]{"test_id"})
//        .setTableFillList(tableFillList)
        // 自定义 mapper 父类
        // .setSuperMapperClass("com.baomidou.demo.TestMapper")
        // 自定义 service 父类
        // .setSuperServiceClass("com.baomidou.demo.TestService")
        // 自定义 service 实现类父类
        // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
        // 自定义 controller 父类
        // .setSuperControllerClass("com.baomidou.demo.TestController")
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        .setEntityColumnConstant(true)
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
//        .setEntityBuilderModel(true)
        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
        .setEntityLombokModel(true)
        // Boolean类型字段是否移除is前缀处理
        // .setEntityBooleanColumnRemoveIsPrefix(true)
        .setRestControllerStyle(true)
//        .setControllerMappingHyphenStyle(true)
    ).setPackageInfo(
      // 包配置
      new PackageConfig()
        .setModuleName("customer")
        // 自定义包路径
        .setParent("cn.com.yto56")
        // 这里是控制器包名，默认 web
        .setController("controller")
//    ).setCfg(
//      // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
//      new InjectionConfig() {
//        @Override
//        public void initMap() {
//          Map<String, Object> map = new HashMap<>();
//          map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//          this.setMap(map);
//        }
//      }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
//        // 自定义输出文件目录
//        @Override
//        public String outputFile(TableInfo tableInfo) {
//          return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
//        }
//      }))
    ).setDataSource(
      // 数据源配置
      new DataSourceConfig()
        // 数据库类型
        .setDbType(DbType.MYSQL)
//        .setTypeConvert(new MySqlTypeConvert() {
//          // 自定义数据库表字段类型转换【可选】
//          @Override
//          public DbColumnType processTypeConvert(String fieldType) {
//            System.out.println("转换类型：" + fieldType);
//            if (fieldType.toLowerCase().contains("tinyint")) {
//              return DbColumnType.BOOLEAN;
//            }
//            return super.processTypeConvert(fieldType);
//          }
//        })
//        .setDriverName("oracle.jdbc.driver.OracleDriver")
//        .setUsername("ytmdm")
//        .setPassword("M9RiEODE")
//        .setUrl("jdbc:oracle:thin:@//10.129.220.16:1521/uatmdm")

          .setDriverName("com.mysql.jdbc.Driver")
          .setUsername("root")
          .setPassword("root123")
          .setUrl("jdbc:mysql://10.1.189.102:3306/oppltfm?useUnicode=true&characterEncoding=utf-8")
    );

    // 执行生成
    mpg.execute();
    System.out.println("======完成======");

    // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
//    System.err.println(mpg.getCfg().getMap().get("abc"));
  }
}
