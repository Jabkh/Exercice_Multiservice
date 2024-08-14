package org.example.config;

import org.example.infrastructure_springdata.portimpl.UserServiceImpl;
import org.example.infrastructure_springdata.portimpl.OrderServiceImpl;
import org.example.infrastructure_springdata.repository.UserRepository;
import org.example.infrastructure_springdata.repository.OrderRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class RestAppInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;

    public RestAppInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("UserService", new UserService(new UserServiceImpl(infraContext.getBean(UserRepository.class))));
        registry.registerSingleton("OrderService", new OrderServiceImpl(infraContext.getBean(OrderRepository.class)));
    }
}