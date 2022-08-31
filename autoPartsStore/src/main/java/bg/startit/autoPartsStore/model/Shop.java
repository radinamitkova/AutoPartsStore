package bg.startit.autoPartsStore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class Shop {

    private Integer id;
    private String name;
    private User owner;
    private Storage storage;
    private BigDecimal budget;

}
