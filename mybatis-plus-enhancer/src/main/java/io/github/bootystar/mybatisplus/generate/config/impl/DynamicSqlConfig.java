package io.github.bootystar.mybatisplus.generate.config.impl;

import io.github.bootystar.mybatisplus.enhance.helper.SqlHelper;
import io.github.bootystar.mybatisplus.enhance.helper.unmodifiable.DynamicSqlHelper;
import io.github.bootystar.mybatisplus.generate.config.base.CustomConfig;
import io.github.bootystar.mybatisplus.generate.info.ClassInfo;
import lombok.Getter;

/**
 * SQL拼接配置类
 *
 * @author bootystar
 */
@Getter
public class DynamicSqlConfig extends CustomConfig {

    {
        selectDTO = new ClassInfo(SqlHelper.class);
        mapperDTO = new ClassInfo(DynamicSqlHelper.class);
    }

    public static class Builder extends CustomConfig.Builder<DynamicSqlConfig, Builder> {
        private final DynamicSqlConfig config = new DynamicSqlConfig();

        @Override
        protected DynamicSqlConfig getConfig() {
            return config;
        }

        @Override
        protected Builder getBuilder() {
            return this;
        }

        /**
         * 不生成重写的方法
         *
         * @return {@code U }
         * @author bootystar
         */
        public Builder disableOverrideMethods() {
            this.getConfig().overrideMethods = false;
            return this.getBuilder();
        }


    }


}


