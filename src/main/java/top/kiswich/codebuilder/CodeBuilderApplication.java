package top.kiswich.codebuilder;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("top.kiswich.codebuilder.dao")
public class CodeBuilderApplication implements CommandLineRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		ConfigurableApplicationContext run = SpringApplication.run(CodeBuilderApplication.class, args);

	}



	@Override
	public void run(String... args) throws Exception {
		List<String> tables = new ArrayList<>();

		Connection connection = DriverManager.getConnection("jdbc:mysql:///DB_TEST", "root", "root");
		PreparedStatement showTables = connection.prepareStatement("show tables");
		ResultSet resultSet = showTables.executeQuery();
		while (resultSet.next()){
			tables.add(resultSet.getString("Tables_in_"+"DB_TEST".toLowerCase()));
		}

		System.out.println(Arrays.toString(tables.toArray()));


	}
}
