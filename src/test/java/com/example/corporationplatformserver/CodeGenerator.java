package com.example.corporationplatformserver;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/corporation_platform?userUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username = "root";
        String password = "y1163273458";
        String mapperLocation = "E:\\project\\corporation-platform-server\\src\\main\\resources\\mappers";
        String tables = "corporationm_table,user_table,corporation_table,activity_table,notice_table,process_table,news_table";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("YeKaihui") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\project\\corporation-platform-server\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("corporationplatformserver")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTableSuffix("_table"); // 设置过滤表后缀
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
