package bg.startit.autoPartsStore.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void getUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/client1"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    @WithMockUser("ivan")
    public void getUserById_exected_ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/client1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



    @Test
    public void getAllProductsByASCPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/search/asc_price"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllProductsByDESCPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/search/desc_price"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}

