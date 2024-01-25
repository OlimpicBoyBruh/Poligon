package ru.sberbank.jd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.sberbank.jd.controller.GiftShopController;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.service.GiftsService;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(GiftShopController.class)
public class GiftShopRepositoryTest {

    @MockBean
    private GiftsService giftsService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;


    @Test
    public void addGiftTest() throws Exception {
        Gift worker = new Gift(1, "Iphone", "500");
        String giftJson = mapper.writeValueAsString(worker);
        mockMvc.perform(post("/catalog/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(giftJson).characterEncoding("utf-8"))
                .andExpect(status().isOk());
        verify(giftsService, times(1)).addGift(new GiftInput(1, "Iphone"));
    }

    @Test
    public void buyGiftTest() throws Exception {
        Gift worker = new Gift(1, "Iphone", "500");
        when(giftsService.getGift(worker.getArticle())).thenReturn(worker);
        mockMvc.perform(get("/catalog/{article}", "500")).andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(1))
                .andExpect(jsonPath("$.content").value("Iphone"))
                .andExpect(jsonPath("$.article").value("500"));
    }

    @Test
    public void updatePriceTest() throws Exception {
        Gift gift = new Gift(1,"Iphone", "500");
        when(giftsService.udpdateGift("500", 1)).thenReturn(gift);
        MockHttpServletRequestBuilder request = put("/catalog/update")
                .param("article", gift.getArticle())
                .param("price", String.valueOf(gift.getPrice()))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.article").value(gift.getArticle()))
                .andExpect(jsonPath("$.price").value(gift.getPrice()));
    }



    @Test
    public void catalogTest() throws Exception {
        Gift worker = new Gift(1, "Iphone", "500");
        List<Gift> giftList = new ArrayList<>();
        giftList.add(worker);
        when(giftsService.getAllGift()).thenReturn(giftList);
        mockMvc.perform(get("/catalog")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(1))
                .andExpect(jsonPath("$[0].content").value("Iphone"))
                .andExpect(jsonPath("$[0].article").value("500"));
    }
    @Test
    public void giftSaleTest() throws Exception {
        Gift worker = new Gift(1, "Iphone", "500");
        when(giftsService.selling("500")).thenReturn(worker);

        mockMvc.perform(delete("/catalog/sell").param("article", "500"))
                .andExpect(status().isOk());
        verify(giftsService).selling("500");
    }

}
