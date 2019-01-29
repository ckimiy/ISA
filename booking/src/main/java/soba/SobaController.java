package soba;

import hotel.Hotel;
import hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SobaController {

    @Autowired
    private SobaService sobaService;

    @Autowired
    private HotelService hotelService;



    @RequestMapping(
            method = RequestMethod.GET,
            value = "/sobe",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<Soba>> getAll(){

        List<Soba> hotel = sobaService.findAll();

        return new ResponseEntity<List<Soba>>(hotel, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/sobe/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Soba> getSoba(@PathVariable("id") long id) throws Exception {
        Soba hotel = this.sobaService.getOne(id);
        if(hotel == null){
            return new ResponseEntity<Soba>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Soba>(hotel, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/sobe",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Soba> insertSoba(@RequestBody Soba soba, @PathVariable ("id") long id) throws Exception{
        Soba createdSoba  = this.sobaService.create(soba);
        Hotel hotel =  hotelService.getOne(id);
        hotel.getKonfiguracijaSoba().add(createdSoba);
        hotelService.update(hotel);
        return new ResponseEntity<Soba>(createdSoba, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/sobe/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Soba> updateSoba(@PathVariable("id") long id, @RequestBody Soba soba) throws Exception{
        Soba sobe = this.sobaService.getOne(id);

        if(sobe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Soba updateSoba = this.sobaService.update(soba);
        if (updateSoba == null) {
            return new ResponseEntity<Soba>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateSoba, HttpStatus.OK);
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/soba/{id}"
    )
    public ResponseEntity<Soba> deleteSoba(@PathVariable("id") long id) throws Exception{
        this.sobaService.deleteById(id);
        return new ResponseEntity<Soba>(HttpStatus.NO_CONTENT);
    }

}
