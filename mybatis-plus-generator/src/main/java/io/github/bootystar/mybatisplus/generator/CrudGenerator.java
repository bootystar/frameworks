package io.github.bootystar.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import io.github.bootystar.mybatisplus.generator.config.CustomConfig;
import io.github.bootystar.mybatisplus.generator.core.ReturnResult;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author booty
 * @Date 2023/7/13 15:34
 * @see  com.baomidou.mybatisplus.generator.config.ConstVal;
 */

public class CrudGenerator extends BaseGenerator {
    public CrudGenerator(String url, String username, String password) {
        super(url, username, password);
    }

    @Override
    protected void init() {
        super.init();

        strategyConfigBuilder.controllerBuilder().enableRestStyle();
        templateConfigBuilder.controller("/crud/controller.java");
        templateConfigBuilder.service("/crud/service.java");
        templateConfigBuilder.serviceImpl("/crud/serviceImpl.java");
        templateConfigBuilder.mapper("/crud/mapper.java");
        templateConfigBuilder.xml("/crud/mapper.xml");
        templateConfigBuilder.entity("/crud/entity.java");
//        customConfigBuilder.returnResultClass(ReturnResult.class);
        customConfigBuilder.returnResultGenericType(true);
        customConfigBuilder.returnResultDefaultStaticMethodName("success");
        customConfigBuilder.pageByDto(true);
        customConfigBuilder.exportExcel(true);
        customConfigBuilder.insertExcludeField("createTime","updateTime","version");
        customConfigBuilder.updateExcludeField("createTime","updateTime");
        customConfigBuilder.orderColumn("create_time",true);
        customConfigBuilder.requestBody(true);
        customConfigBuilder.addValidated(true);
    }

    @Override
    public void execute() {

        DataSourceConfig dataSourceConfig = dataSourceConfigBuilder.build();

        GlobalConfig globalConfig = globalConfigBuilder.build();

        StrategyConfig strategyConfig = strategyConfigBuilder.build();

        TemplateConfig templateConfig = templateConfigBuilder.build();

        InjectionConfig injectionConfig = injectionConfigBuilder.build();

        PackageConfig packageConfig = packageConfigBuilder.build();

        CustomConfig customConfig = customConfigBuilder.build();
        String dtoPackage = customConfig.getDtoPackage();
        String voPackage = customConfig.getVoPackage();



        LinkedList<CustomFile> customFiles = new LinkedList<>();
        CustomFile InsertDto = new CustomFile.Builder().fileName("InsertDto.java").templatePath("/crud/entityInsertDto.java.vm").packageName(dtoPackage).build();
        customFiles.add(InsertDto);
        CustomFile updateDto = new CustomFile.Builder().fileName("UpdateDto.java").templatePath("/crud/entityUpdateDto.java.vm").packageName(dtoPackage).build();
        customFiles.add(updateDto);
        if (customConfig.getPageByDto()){
            CustomFile selectDto = new CustomFile.Builder().fileName("SelectDto.java").templatePath("/crud/entitySelectDto.java.vm").packageName(dtoPackage).build();
            customFiles.add(selectDto);
            CustomFile vo = new CustomFile.Builder().fileName("Vo.java").templatePath("/crud/entityVo.java.vm").packageName(voPackage).build();
            customFiles.add(vo);
            if (customConfig.getExportExcel()){
                CustomFile exportVo = new CustomFile.Builder().fileName("ExportVo.java").templatePath("/crud/entityExportVo.java.vm").packageName(voPackage).build();
                customFiles.add(exportVo);
            }
        }
        customConfigBuilder.customFile(customFiles);

        CustomGenerator customGenerator =
                new CustomGenerator(dataSourceConfig)
                        .global(globalConfig)
                        // 包配置
                        .packageInfo(packageConfig)
                        // 策略配置
                        .strategy(strategyConfig)
                        // 模板配置
                        .template(templateConfig)
                        // 注入配置
                        .injection(injectionConfig)
                        // 自定义配置
                        .custom(customConfig)
        ;

        customGenerator.execute();
    }
}
