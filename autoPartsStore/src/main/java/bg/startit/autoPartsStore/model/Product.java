package bg.startit.autoPartsStore.model;

import lombok.*;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Product {


    private String id;
    private String carBrand;
    @NonNull
    private BigDecimal price;
    private Storage storage;
    private Shop shop;

}
