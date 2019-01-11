package soba;

import javax.persistence.*;

@Entity
@Table(name = "Soba")
public class Soba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
