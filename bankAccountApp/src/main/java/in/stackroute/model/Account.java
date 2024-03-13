package in.stackroute.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Account {

    @Id
    @GeneratedValue
    @Column(name= "a_id")
    private int id;

    @Column(name = "a_holders")
    private String name;

    @Column(name = "a_add")
    private String add;

    @Column(name = "a_type")
    private String type;

    @Column(name = "a_status")
    private String status;

    public Account(String name, String add, String type, String status){
        this.name = name;
        this.add = add;
        this.type = type;
        this.status = status;
    }


}
