import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import io.github.bootystar.mybatisplus.generator.CrudGenerator;
import io.github.bootystar.mybatisplus.generator.ParentGenerator;
import io.github.bootystar.mybatisplus.generator.core.CustomMapper;
import io.github.bootystar.mybatisplus.generator.core.CustomService;
import io.github.bootystar.mybatisplus.generator.core.CustomServiceImpl;

import java.util.Collections;


/**
 * @author booty
 * @since 2023/7/13 14:44
 */
public class Test1 {

//    private static String url ="jdbc:mysql://localhost:3306/ds_wwsg_wm?useUnicode=true&characterEncoding=UTF-8";
    private static String url ="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
    private static String username ="root";
    private static String password ="root";
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        CrudGenerator generator = new CrudGenerator(url, username, password);

        generator
                .globalConfigBuilder()
                .dateType(DateType.ONLY_DATE)
//                .enableSwagger()
                .outputDir(projectPath+ "/mybatis-plus-generator/src/test/java")

        ;  // 指定输出目录
        generator
                .customConfigBuilder()
                .jakartaApi(false)
                .enableValidated(true)
                .orderColumn("age",true)
                .orderColumn("name", false)
                .orderColumn("id_card", true)
                .DTOPackage("entity.dto")
                .VOPackage("entity.vo")
                .exportOnVO(true)
                .importOnVO(true)
//                .VOFieldAnnotation(true)
//                .VOResultMap(false)
//                .restStyle(true)
//                .allPost(true)

//                .requestBody(true)
//                .enableOrigins(true)
//                .generateDelete(true)
//                .voResultMap(true)
//                .generateUpdate(false)
                .generateExport(true)
                .generateImport(true)
//                .generateInsert(false)
//                .generateDelete(false)
//                .generateSelect(true)


        ;
        generator.strategyConfigBuilder()
                .entityBuilder()
                .enableFileOverride()
                .enableActiveRecord()
                .idType(IdType.ASSIGN_ID)
                .enableTableFieldAnnotation()
                .logicDeleteColumnName("deleted")
        ;

        generator.strategyConfigBuilder()
                .serviceBuilder()
                .enableFileOverride()
            ;

        generator.strategyConfigBuilder()
                .mapperBuilder()
                .enableFileOverride()
        ;
        generator.strategyConfigBuilder()
                .entityBuilder()
                .enableLombok()
                .enableFileOverride()
        ;


        generator
                .packageConfigBuilder()
                .parent("bootystar.test")
                .entity("entity.pojo")
//        .moduleName("v4")
                .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/mybatis-plus-generator/src/test/resources/xml"))
        ;
        generator.globalConfigBuilder()
//                .enableSpringdoc()
//                .enableSwagger()
                ;

        generator.execute("user");
    }

}
