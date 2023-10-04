package dio.projetoSpringBootDIO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto SpringBoot ferado via Spring Initializr.
 * Os seguintes módulos foram selecionados:
 * - Spring Data Jpa
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * @author Douglas
 * */
@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
