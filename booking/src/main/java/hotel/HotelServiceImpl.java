package hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }


    @Override
    public Hotel getOne(long id) {
        return hotelRepository.getOne(id);
    }

    @Override
    public Hotel create(Hotel hotel) {
        Hotel savedDrzava = this.hotelRepository.save(hotel);
        return savedDrzava;
    }


    @Override
    public Hotel update(Hotel hotel)throws Exception{
        Hotel hotelUpdt = this.hotelRepository.getOne(hotel.getId());

        if(hotelUpdt == null){
            throw new Exception("NEMA");
        }
        hotelUpdt.setAdresa(hotel.getAdresa());
        hotelUpdt.setCenovnik(hotel.getCenovnik());
        hotelUpdt.setNaziv(hotel.getNaziv());
        hotelUpdt.setOpis(hotel.getOpis());
        hotelUpdt.setKonfiguracijaSoba(hotel.getKonfiguracijaSoba());

        Hotel updateHotel = this.hotelRepository.save(hotelUpdt);
        return updateHotel;
    }

    @Override
    public void deleteById(long id) {
        this.hotelRepository.deleteById(id);
    }

}
