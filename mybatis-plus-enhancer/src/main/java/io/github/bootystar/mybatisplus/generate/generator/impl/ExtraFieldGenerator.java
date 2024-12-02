package io.github.bootystar.mybatisplus.generate.generator.impl;


import io.github.bootystar.mybatisplus.enhance.core.EnhanceMapper;
import io.github.bootystar.mybatisplus.enhance.core.EnhanceService;
import io.github.bootystar.mybatisplus.enhance.core.impl.ExtraFieldServiceImpl;
import io.github.bootystar.mybatisplus.generate.config.impl.ExtraFiledConfig;
import io.github.bootystar.mybatisplus.generate.generator.core.AbstractGenerator;

/**
 * 额外属性型生成器
 * 生成可供查询的额外属性
 *
 * @author booty
 */
public class ExtraFieldGenerator extends AbstractGenerator<ExtraFiledConfig, ExtraFiledConfig.Builder> {

    public ExtraFieldGenerator(String url, String username, String password) {
        super(url, username, password, new ExtraFiledConfig.Builder());
        this.strategyConfigBuilder.serviceBuilder()
                .serviceTemplate("/templates/enhance/service.java")
                .serviceImplTemplate("/templates/extra/serviceImpl.java")
        ;
        this.strategyConfigBuilder.mapperBuilder()
                .mapperTemplate("/templates/enhance/mapper.java")
                .mapperXmlTemplate("/templates/enhance/mapper.xml")
        ;
        this.strategyConfigBuilder.serviceBuilder()
                .superServiceClass(EnhanceService.class)
                .superServiceImplClass(ExtraFieldServiceImpl.class)
        ;
        this.strategyConfigBuilder.mapperBuilder()
                .superClass(EnhanceMapper.class)
        ;
    }

}
