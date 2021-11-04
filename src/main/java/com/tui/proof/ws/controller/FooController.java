package com.tui.proof.ws.controller;

import com.tui.proof.dto.OrderDTO;
import com.tui.proof.mapper.OrderMapper;
import com.tui.proof.model.Order;
import com.tui.proof.observer.MiquelObserver;
import com.tui.proof.observer.Observer;
import com.tui.proof.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Log4j2
@RestController
public class FooController {
    private Observer observer = new MiquelObserver();
    @Autowired
    EntityManager entityManager;
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    void test() {
        log.info("Foo controller");
    }

    @PostMapping("/insertOrder")
    public ResponseEntity<OrderDTO> insertOrder(@RequestBody OrderDTO orderDTO) {
        if (orderDTO.getNumberOfPilotes() == 5 || orderDTO.getNumberOfPilotes() == 10 || orderDTO.getNumberOfPilotes() == 15) {
            Order order = OrderMapper.INSTANCE.dtoToModel(orderDTO);
            order = orderService.insertOrder(order);
            orderDTO = OrderMapper.INSTANCE.modelToDTO(order);
            observer.update(order);
            return ok(orderDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<Boolean> updateOrder(@RequestBody OrderDTO orderDTO) {

        if (orderDTO.getNumberOfPilotes() == 5 || orderDTO.getNumberOfPilotes() == 10 || orderDTO.getNumberOfPilotes() == 15) {

            Order order = OrderMapper.INSTANCE.dtoToModel(orderDTO);
            Boolean result = orderService.update(order);
            if (result) {

                return ok(result);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/searchByFirstName")
    public ResponseEntity<List<Order>> searchByFirstName(@RequestParam String firstName, String userId) {

        if (userId.equals("admin")) { //This kind of authorization check should be implement with session
            TypedQuery<Order> query =
                    entityManager.createNamedQuery("Client.findByFirstName", Order.class);
            query.setParameter("firstName", firstName);
            List<Order> results = query.getResultList();
            return ok(results);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("/searchByLastName")
    public ResponseEntity<List<Order>> searchByLastName(@RequestParam String lastName, String userId) {
        if (userId.equals("admin")) {//This kind of authorization check should be implement with session
            TypedQuery<Order> query =
                    entityManager.createNamedQuery("Client.findByLastName", Order.class);
            query.setParameter("lastName", lastName);
            List<Order> results = query.getResultList();
            return ok(results);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("/searchByTelephone")
    public ResponseEntity<List<Order>> searchByTelephone(@RequestParam String telephone, String userId) {
        if (userId.equals("admin")) {//This kind of authorization check should be implement with session
            TypedQuery<Order> query =
                    entityManager.createNamedQuery("Client.findByTelephone", Order.class);
            query.setParameter("telephone", telephone);
            List<Order> results = query.getResultList();
            return ok(results);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }


}
