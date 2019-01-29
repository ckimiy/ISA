package soba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SobaServiceImpl implements SobaService{

    @Autowired
    private SobaRepository sobaRepository;

    @Override
    public List<Soba> findAll() {
        return sobaRepository.findAll();
    }


    @Override
    public Soba getOne(long id) {
        return sobaRepository.getOne(id);
    }

    @Override
    public Soba create(Soba soba) {
        Soba savedSoba = this.sobaRepository.save(soba);
        return savedSoba;
    }

    @Override
    public Soba update(Soba soba)throws Exception{
        Soba sobaUpdt = this.sobaRepository.getOne(soba.getId());

        if(sobaUpdt == null){
            throw new Exception("NEMA");
        }
        sobaUpdt.setCena_nocenja(soba.getCena_nocenja());
        sobaUpdt.setDodatne_usluge(soba.getDodatne_usluge());
        sobaUpdt.setPopust(soba.getPopust());

        Soba updateSoba = this.sobaRepository.save(sobaUpdt);
        return updateSoba;
    }

    @Override
    public void deleteById(long id) {
        this.sobaRepository.deleteById(id);
    }

}
