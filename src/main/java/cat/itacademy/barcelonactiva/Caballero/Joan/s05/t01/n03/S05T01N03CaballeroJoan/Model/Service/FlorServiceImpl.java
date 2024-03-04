package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Model.Service;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Model.DTO.FlorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
public class FlorServiceImpl implements FlorService{

    @Autowired
    private WebClient webClient;

    @Override
    public FlorDTO createFlor(FlorDTO florDTO) {
        try{
            return webClient.post()
                    .uri("/flor/add")
                    .bodyValue(florDTO)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        }catch(WebClientResponseException e){
            System.out.println(e.getResponseBodyAsString());
            throw new RuntimeException("Error al carregar la flor.");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            throw new RuntimeException("Error al carregar la flor.");
        }
    }

    @Override
    public FlorDTO updateFlor(int id, FlorDTO florDTO) {
        try {
            return webClient
                    .put()
                    .uri("/flor/update/{id}", id)
                    .bodyValue(florDTO)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        }catch(WebClientResponseException e){
            System.out.println(e.getResponseBodyAsString());
            throw new RuntimeException("Error al carregar la flor.");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            throw new RuntimeException("Error al carregar la flor.");
        }
    }

    @Override
    public String deleteFlor(int id) {
        try {
            return webClient
                    .delete()
                    .uri("/flor/delete/{id}", id)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }catch(WebClientResponseException e){
            System.out.println(e.getResponseBodyAsString());
            throw new RuntimeException("Error al carregar la flor.");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            throw new RuntimeException("Error al carregar la flor.");
        }
    }

    @Override
    public FlorDTO getOneFlor(int id) {
        try {
            return webClient
                    .get()
                    .uri("/flor/getOne/{id}", id)
                    .retrieve()
                    .bodyToMono(FlorDTO.class)
                    .block();
        }catch(WebClientResponseException e){
            System.out.println(e.getResponseBodyAsString());
            throw new RuntimeException("Error al carregar la flor.");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            throw new RuntimeException("Error al carregar la flor.");
        }
    }

    @Override
    public List<FlorDTO> getAllFlors() {
        try {
            return webClient
                    .get()
                    .uri("/flor/getAll")
                    .retrieve()
                    .bodyToFlux(FlorDTO.class)
                    .collectList()
                    .block();
        }catch(WebClientResponseException e){
            System.out.println(e.getResponseBodyAsString());
            throw new RuntimeException("Error al carregar el llistat de flors.");
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
            throw new RuntimeException("Error al carregar el llistat de flors.");
        }
    }
}
