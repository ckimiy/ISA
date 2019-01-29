package hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soba.SobaService;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @Autowired
    private SobaService sobaService;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/hoteli",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<Hotel>> getAll(){

        List<Hotel> hotel = hotelService.findAll();

        return new ResponseEntity<List<Hotel>>(hotel, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/hoteli/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") long id) throws Exception {
        Hotel hotel = this.hotelService.getOne(id);
        if(hotel == null){
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/hoteli",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Hotel> insertHotel(@RequestBody Hotel hotel) throws Exception{
        Hotel createdHotel  = this.hotelService.create(hotel);

        return new ResponseEntity<Hotel>(createdHotel, HttpStatus.CREATED);
    }
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/hoteli/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") long id, @RequestBody Hotel hotel) throws Exception{
        Hotel hoteli = this.hotelService.getOne(id);

        if(hoteli == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Hotel updateHotel = this.hotelService.update(hotel);
        if (updateHotel == null) {
            return new ResponseEntity<Hotel>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateHotel, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/hotel/{id}"
    )
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") long id) throws Exception{
        this.hotelService.deleteById(id);
        return new ResponseEntity<Hotel>(HttpStatus.NO_CONTENT);
    }


}
