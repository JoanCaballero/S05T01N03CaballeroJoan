package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Model.Service;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Model.DTO.FlorDTO;

import java.util.List;

public interface FlorService {
    FlorDTO createFlor(FlorDTO florDTO);
    FlorDTO updateFlor(int id, FlorDTO florDTO);
    String deleteFlor(int id);
    FlorDTO getOneFlor(int id);
    List<FlorDTO> getAllFlors();
}
