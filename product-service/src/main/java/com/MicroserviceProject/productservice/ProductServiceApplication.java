package com.MicroserviceProject.productservice;

import com.MicroserviceProject.productservice.dto.TableDB;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	private  JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===============================Start Product Service");
		// String sql = "SELECT person_id, first_name, last_name FROM persons";
		String sql= "SELECT table_name, owner, tablespace_name FROM all_tables where lower(table_name) = 'product'";

		List<TableDB> persons = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TableDB.class));
		persons.forEach(System.out::println);
		System.out.println("===============================End Product Service");
	}
}
