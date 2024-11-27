package ilerna.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Montain {
    private int id;
    private String nom;
    private String comarca;
    private String unitatDeRelleu;
    private int altura;
    private String destacat;
}