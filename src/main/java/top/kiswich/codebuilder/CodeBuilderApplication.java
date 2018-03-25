package top.kiswich.codebuilder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;


@SpringBootApplication
@EnableJpaRepositories("top.kiswich.codebuilder.dao")
public class CodeBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeBuilderApplication.class, args);
    }


    /**
     * 初始化 完成temp file的配置
     * 目录的清理，在session退出后立即清理
     * (t可通过spring session实现)
     */
    @Bean
    public File getTempDir() {
        String userHome = System.getProperty("user.home");
        String tempFir = "CodeBuilderTemp";
        File codeTemp;
        //23333没想到好的目录，暂时先这样写吧
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            codeTemp = new File(userHome, tempFir);
        } else {
            codeTemp = new File(userHome, tempFir);
        }
        return codeTemp;
    }
}
