package org.example.config;

import org.example.infrastructure_springdata.portimpl.UserServiceImpl;
import org.example.infrastructure_springdata.portimpl.OrderServiceImpl;
import org.example.infrastructure_springdata.repository.UserRepository;
import org.example.infrastructure_springdata.repository.OrderRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class RestConfigInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext restContext;

    public RestAppInitializer(ConfigurableApplicationContext restContext) {
        this.restContext = restContext;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("UserService", new UserService(new UserServiceImpl(restContext.getBean(UserRepository.class))));
        registry.registerSingleton("OrderService", new OrderServiceImpl(restContext.getBean(OrderRepository.class)));
    }
}