package com.claro.resttest.Config;

import com.claro.resttest.Entities.Celular;
import com.claro.resttest.Entities.Router;
import com.claro.resttest.Entities.Usuario;
import com.claro.resttest.Repository.CelularRepository;
import com.claro.resttest.Repository.RouterRepository;
import com.claro.resttest.Repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitialData {
    @Configuration
    class LoadDatabase {

        private final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

        @Bean
        CommandLineRunner initUsers(UsuarioRepository repository) {
            return args -> {
                usuariosDePrueba().forEach((u)->{
                    log.info("TestData " + repository.save(u));
                });
            };
        }
        @Bean
        CommandLineRunner initRouters(RouterRepository repository) {
            return args -> {
                routersDePrueba().forEach((r)->{
                    log.info("TestData " + repository.save(r));
                });
            };
        }
        @Bean
        CommandLineRunner initCells(CelularRepository repository) {
            return args -> {
                celularesDePrueba().forEach((c)->{
                    log.info("TestData " + repository.save(c));
                });
            };
        }
        List<Usuario> usuariosDePrueba(){
            return Arrays.asList(new Usuario[]{
                    new Usuario("Jose","Perez"),
                    new Usuario("Miguelina","Jaquez"),
                    new Usuario("Eugenia","Brito"),
                    new Usuario("Roberto","Gonzalez"),
            });
        }
        List<Celular> celularesDePrueba(){
            return Arrays.asList(new Celular[]{
                    new Celular("IPhone", "8"),
                    new Celular("IPhone", "X"),
                    new Celular("Samsung", "Galaxy"),
                    new Celular("Motorola", "Star")
            });

        }
        List<Router> routersDePrueba(){
            return Arrays.asList(new Router[]{
                    new Router("Baton","FlySpeed"),
                    new Router("Cisco","IS3309"),
                    new Router("Huawei","5e8892")
            });
        }
    }
}
