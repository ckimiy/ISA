package hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> findAll();
    Hotel getOne(long id) throws Exception;;
    Hotel create(Hotel hotel) throws Exception;;
    Hotel update(Hotel hotel) throws Exception;
    void deleteById(long id) throws Exception;;
}
