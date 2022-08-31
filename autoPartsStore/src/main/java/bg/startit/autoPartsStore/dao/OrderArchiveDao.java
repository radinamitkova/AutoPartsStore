package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.model.OrderArchive;

import java.time.LocalDateTime;

public interface OrderArchiveDao {

    int createOrderArchive(OrderArchive order);

    OrderArchive getOrderByDate(LocalDateTime date);

    OrderArchive getTimesProductSold(String productId);

    //OrderArchive getMostSellingParts();

    //String getSecondMostFragileCarBrand();
}
