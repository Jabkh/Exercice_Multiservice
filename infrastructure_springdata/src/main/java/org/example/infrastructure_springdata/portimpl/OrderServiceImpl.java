package org.example.infrastructure_springdata.portimpl;

import org.example.dto.OrderDTO;
import org.example.port.OrderPort;
import org.example.infrastructure_springdata.entity.OrderEntity;
import org.example.infrastructure_springdata.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity, OrderDTO, Long> implements OrderPort {

    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Override
    public List<OrderDTO> getAll() {
        return super.getAll();
    }

    @Override
    public OrderDTO getById(Long id) {
        return super.getById(id);
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        return super.save(orderDTO);
    }

    @Override
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        return super.update(id, orderDTO);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    protected OrderDTO convertToDTO(OrderEntity orderEntity) {
        return new OrderDTO(orderEntity.getOrderId(), orderEntity.getUserId(), orderEntity.getProducts());
    }

    @Override
    protected OrderEntity convertToEntity(OrderDTO orderDTO) {
        return OrderEntity.builder()
                .orderId(orderDTO.getOrderId())
                .userId(orderDTO.getUserId())
                .products(orderDTO.getProducts())
                .build();
    }

    @Override
    protected void setId(OrderEntity orderEntity, Long id) {
        orderEntity.setOrderId(id);
    }
}