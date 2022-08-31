package bg.startit.autoPartsStore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderArchive {

    private Integer id;
    private Integer amount;
    private BigDecimal price;
    private LocalDateTime orderDate;
    private User client;
    private Product product;


}
