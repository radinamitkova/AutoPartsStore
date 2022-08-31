package bg.startit.autoPartsStore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    private String id;
    private String name;
   // private String username;
   // private String password;
    private BigDecimal money;
    private RoleName role;

    public enum RoleName {
        CLIENT,
        OWNER
    }
}
