package dev.mkaue.LeedsDeClientesLojasTal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.mkaue.LeedsDeClientesLojasTal.model.Cliente;
import dev.mkaue.LeedsDeClientesLojasTal.model.Contato;
import dev.mkaue.LeedsDeClientesLojasTal.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    @Test
    void validaCriacaoDeCliente() throws Exception {
        Cliente cliente = new Cliente();
        Contato contato = new Contato();
        contato.setNumeroTelefone("123456789"); // Número válido
        cliente.setContatos(Collections.singletonList(contato));

        when(clienteService.saveCliente(any())).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void validaPadraoDeTelefone() throws Exception {
        Cliente cliente = new Cliente();
        Contato contato = new Contato();
        contato.setNumeroTelefone("123");
        cliente.setContatos(Collections.singletonList(contato));

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(MockMvcResultMatchers.status().isNotAcceptable());
    }

    @Test
    public void salvarEExcluirCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("TESTE_9f!uVMCTa#M9EJ6REPc5dHLVeuK$dvyas8u6cD%dZvj$4cWN7yZLWm46w&hE%_TESTE");

        when(clienteService.saveCliente(any())).thenReturn(cliente);
        clienteService.deleteCliente(cliente.getId());

        System.out.println(cliente);
    }

    @Test
    public void validaRequestJson() throws Exception {

        String apiUrl = "http://localhost:3000/clientes/5";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();
            System.out.println(jsonResponse);

            when(clienteService.saveCliente(Mockito.any())).thenReturn(new Cliente());

            mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonResponse))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
