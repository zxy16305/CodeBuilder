package top.kiswich.codebuilder.pojo.common;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean(name = "tableInfo")
    public List<String> getTableInfoParam() {
        return Arrays.asList(TableConstant.FIELD
                , TableConstant.TYPE
                , TableConstant.COMMENT
                , TableConstant.KEY);
    }



}
