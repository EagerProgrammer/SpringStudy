package com.example.spring_test;

import Persistence.ItemRepository;
import Persistence.RepositoryFactory;
import domain.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTestApplication {

    public static void main(String[] args){
        //ItemRepository itemRepository = new ItemRepository();
        //인스턴스 생성을 다른 팩토리 클래스를 이용해서 생성
        //다른 클래스의 메서드를 이용해서 인스턴스를 생성하는 것을 Factory Pattern이라도 합니다.
        //ItemRepository itemRepository = RepositoryFactory.create();
        //ItemRepository itemRepository1 = RepositoryFactory.create();


        //스프링이 인스턴스를 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryFactory.class);
        ItemRepository itemRepository = context.getBean("create", ItemRepository.class);
        //스프링은 싱글톤 패턴으로 생성하므로 2개의 해시코드는 일치
        ItemRepository itemRepository1 = context.getBean("create", ItemRepository.class);
        System.out.println(System.identityHashCode(itemRepository1));
        System.out.println(System.identityHashCode(itemRepository));

        Item item = itemRepository.get();
        System.out.println(item);

    }

}
