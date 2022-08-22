package ram.learn.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Embeddable
@Table(name="TBL_STUDENT")
public class Student {
	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	private String name;
	private Double Fee;
	private String email;
	private String course;
	private String addr;

}
