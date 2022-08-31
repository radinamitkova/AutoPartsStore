package bg.startit.autoPartsStore.dto;

import bg.startit.autoPartsStore.model.User;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class UserRequest {

    private String  id;
    private String  name;
    @NonNull
    @Pattern(regexp = "^[a-z0-8\\.\\-]+$")
    private String  username;
    @NotNull
    private String  password;
    @Min(value = 1, message = "You enter invalid money!")
    private BigDecimal money;
    private User.RoleName role;

    public String getId() {
        return id;
    }

    public UserRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public UserRequest setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public User.RoleName getRole() {
        return role;
    }

    public UserRequest setRole(User.RoleName role) {
        this.role = role;
        return this;
    }
}
