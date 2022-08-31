package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.model.OrderArchive;
import bg.startit.autoPartsStore.model.Shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface OrderArchiveService {

    void createOrderArchive(String clientId, String productId, Integer amount) throws Exception;

    OrderArchive getOrderByDate(LocalDateTime date);

    BigDecimal getTurnover(Shop shop);
}
