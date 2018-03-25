package ${base.thisPackage}.codebuilder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("${base.thisPackage}.repository")
public class CodeBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeBuilderApplication.class, args);
    }
}
