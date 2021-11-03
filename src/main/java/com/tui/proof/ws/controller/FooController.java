package com.tui.proof.ws.controller;

import com.tui.proof.dto.ClientDTO;
import com.tui.proof.dto.OrderDTO;
import com.tui.proof.mapper.ClientMapper;
import com.tui.proof.mapper.OrderMapper;
import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import com.tui.proof.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Log4j2
@RestController
public class FooController {
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    void test() {
        log.info("Foo controller");
    }

    @PostMapping("/insertOrder")
    public ResponseEntity<OrderDTO> insertOrder(@RequestBody OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.dtoToModel(orderDTO);
        order = orderService.insertOrder(order);
        orderDTO = OrderMapper.INSTANCE.modelToDTO(order);
        return ok(orderDTO);
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<Boolean> updateOrder(@RequestBody OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.dtoToModel(orderDTO);
        Boolean result = orderService.update(order);
        return ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Order>> search(@RequestParam ClientDTO clientDTO) {
        Client client= ClientMapper.INSTANCE.dtoToModel(clientDTO);

    }
}
