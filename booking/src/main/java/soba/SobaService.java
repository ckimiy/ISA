package soba;

import java.util.List;

public interface SobaService {

    List<Soba> findAll();
    Soba getOne(long id) throws Exception;;
    Soba create(Soba hotel) throws Exception;
    Soba update(Soba soba) throws Exception;
    void deleteById(long id) throws Exception;
}
