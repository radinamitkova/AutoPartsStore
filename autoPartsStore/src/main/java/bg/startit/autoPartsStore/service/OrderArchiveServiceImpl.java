package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.dao.OrderArchiveDao;
import bg.startit.autoPartsStore.model.OrderArchive;
import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.Shop;
import bg.startit.autoPartsStore.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Transactional
@Service
public class OrderArchiveServiceImpl implements OrderArchiveService {

    private final OrderArchiveDao orderArchiveDao;
    private UserService userService;
    private ProductService productService;

    public OrderArchiveServiceImpl(OrderArchiveDao orderArchiveDao) {
        this.orderArchiveDao = orderArchiveDao;
    }

    @Override
    public void createOrderArchive(String clientId, String productId, Integer amount) throws Exception {
        User client = this.userService.getUserById(clientId);
        Product product = this.productService.getProductById(productId);

        OrderArchive newOrder = new OrderArchive();
        newOrder.setClient(client);
        newOrder.setProduct(product);
        newOrder.setAmount(amount);
        newOrder.setPrice(product.getPrice().multiply(BigDecimal.valueOf(amount)));
        newOrder.setOrderDate(LocalDateTime.now());

        int status = orderArchiveDao.createOrderArchive(newOrder);
        if (status == 0){
            throw new Exception("This order is already made!");
        }
    }

    @Override
    public OrderArchive getOrderByDate(LocalDateTime date) {
        OrderArchive order = orderArchiveDao.getOrderByDate(date);

        order.setClient(userService.getUserById(order.getClient().getId()));
        order.setProduct(productService.getProductById(order.getProduct().getId()));

        return order;
    }

    @Override
    public BigDecimal getTurnover(Shop shop){
        BigDecimal newBudget = BigDecimal.ZERO;

        while (getOrderByDate(LocalDateTime.now()) != null) {
            newBudget = newBudget.add(getOrderByDate(LocalDateTime.now()).getPrice());
        }
        return shop.getBudget().subtract(newBudget);
    }
}
