package bg.startit.autoPartsStore.controller;

import bg.startit.autoPartsStore.model.Shop;
import bg.startit.autoPartsStore.service.OrderArchiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    private final OrderArchiveService orderArchiveService;

    public OrderController(OrderArchiveService orderArchiveService) {
        this.orderArchiveService = orderArchiveService;
    }

    @PreAuthorize("hasRole('OWNER')")
    @GetMapping("statistics/turnover/")
    public ResponseEntity<?> getTurnover(Shop shop){
        return ResponseEntity.ok(orderArchiveService.getTurnover(shop));
    }

}