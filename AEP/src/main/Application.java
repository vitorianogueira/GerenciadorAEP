package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        Tarefa obj;
        obj = new Tarefa(1);
        test.add(obj);
        obj=new Tarefa(2);
        test.add(obj);
        obj=new Tarefa(3);
        test.add(obj);
    
        SpringApplication.run(Application.class, args);
    }
}