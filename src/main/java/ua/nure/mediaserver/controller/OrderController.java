package ua.nure.mediaserver.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.nure.mediaserver.domain.Order;
import ua.nure.mediaserver.domain.PrincipalDetails;
import ua.nure.mediaserver.domain.User;
import ua.nure.mediaserver.domain.dto.OrderDTO;
import ua.nure.mediaserver.repository.UserRepository;
import ua.nure.mediaserver.service.OrderService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Order>> gelAllOrders(@RequestHeader("Authorization") String jwt) {
        System.out.println(jwt);
        List<Order> orderList = orderService.getAllOrders();
        System.out.println(orderList.size());
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO,
                                                   @RequestHeader("Authorization") String jwt) {
        //todo validity check


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        if (authentication != null) {
            System.out.println(jwt);
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            String emailOfCreator = principalDetails.getUsername();
            User user = userRepository.readByEmail(emailOfCreator);
            ObjectId creatorId = user.get_id();
            System.out.println(user.toString());

            Order orderToSave = Order.builder()
                    .setCategories(orderDTO.getCategories())
                    .setCreationDate(new Date())
                    .setCreatorId(creatorId)
                    .setDeadline(orderDTO.getDeadline())
                    .setHashtags(orderDTO.getHashtags())
                    .setDescription(orderDTO.getDescription())
                    .setDislikes(0)
                    .setLikes(0)
                    .setPrivate(orderDTO.isPrivate())
                    .setLocation(orderDTO.getLocation())
                    .setPhotoCount(orderDTO.getPhotoCount())
                    .setVideoCount(orderDTO.getVideoCount())
                    .setPaid(orderDTO.isPaid())
                    .setMoney(orderDTO.getMoney())
                    .setFullname(user.getName() + " " + user.getSurname())
                    .setTitle(orderDTO.getTitle())
                    .build();

            System.out.println(orderToSave.toString());

            orderService.createOrder(orderToSave);


            return new ResponseEntity<>(orderToSave, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
