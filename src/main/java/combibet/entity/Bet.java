package combibet.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="bet_type")
@SequenceGenerator(name = "BET_SEQ_GENERATOR", sequenceName = "BET_SEQ", initialValue = 1, allocationSize = 1)

public abstract class Bet {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BET_SEQ_GENERATOR")
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime date;

	private String formattedDate;
	
	private String field;

	private String selection;

	private double odd;
	
	private double currentOddInCombi;

	private double ante;

	@ManyToOne
	private Gambler gambler;

	@ManyToOne
	@JoinColumn(name = "combi_id")
	private Combi combi;
	
	private BetType type;

	private BetStatus status;

	private String beforeComment;

	private String afterComment;

	public String formatDate() {

		LocalDateTime date = this.date;

		String day = "";
		String month = "";

		if (date.getDayOfWeek().toString() == "MONDAY") {
			day = "Lun";
		}
		if (date.getDayOfWeek().toString() == "TUESDAY") {
			day = "Mar";
		}
		if (date.getDayOfWeek().toString() == "WEDNESDAY") {
			day = "Mer";
		}
		if (date.getDayOfWeek().toString() == "THURSDAY") {
			day = "Jeu";
		}
		if (date.getDayOfWeek().toString() == "FRIDAY") {
			day = "Ven";
		}
		if (date.getDayOfWeek().toString() == "SATURDAY") {
			day = "Sam";
		}
		if (date.getDayOfWeek().toString() == "SUNDAY") {
			day = "Dim";
		}

		if (date.getMonth().toString() == "JANUARY") {
			month = "Janvier";
		}
		if (date.getMonth().toString() == "FEBRUARY") {
			month = "F??vrier";
		}
		if (date.getMonth().toString() == "MARCH") {
			month = "Mars";
		}
		if (date.getMonth().toString() == "APRIL") {
			month = "Avril";
		}
		if (date.getMonth().toString() == "MAY") {
			month = "Mai";
		}
		if (date.getMonth().toString() == "JUNE") {
			month = "Juin";
		}
		if (date.getMonth().toString() == "JULY") {
			month = "Juillet";
		}
		if (date.getMonth().toString() == "AUGUST") {
			month = "Ao??t";
		}
		if (date.getMonth().toString() == "SEPTEMBER") {
			month = "Septembre";
		}
		if (date.getMonth().toString() == "OCTOBER") {
			month = "Octobre";
		}
		if (date.getMonth().toString() == "NOVEMBER") {
			month = "Novembre";
		}
		if (date.getMonth().toString() == "DECEMBER") {
			month = "D??cembre";
		}

		return day + " " + date.getDayOfMonth() + " " + month + " " + date.getYear();
	}

}
