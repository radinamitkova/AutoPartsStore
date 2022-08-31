package bg.startit.autoPartsStore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@RequiredArgsConstructor
public class Storage {

    private Integer id;
    private Product product;
    private Integer capacity;
    @Min(value = 12)
    private Integer stock;
}
